import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.Iterator;
class Emergency
{
int []dist;  
boolean []mark;  
int []mp;  
int []teams;  
int []amount;  
int []shortestPathCount;  
int n, m, start, enmergency;  
  
public void dijkstra(int s){  
    //start->s�ľ���
	dist[s] = 0;  
    amount[s] = teams[s];  
    
	
	//��start��ʼ
    int newP = s;  
    mark[s] = true;  
	//Ѱ��enmegency��Ѱ�ҵ��ýڵ㣬ֹͣѭ����
    while (newP != enmegrgency){  
		//�о��ڵ�newp�Աߵ�i�ڵ㣬������̾���dist���������·����Ŀpathcount
        for (int i = 0; i < n; i++){  
			//���markΪfalse������i�ڵ㡣��ֹ���ֻ�
            if (mark[i] == false){  
				//���previous��start->i��������
                if (dist[i] > dist[newP] + mp[newP][i]){  
                    dist[i] = dist[newP] + mp[newP][i];
					//gather���еľ�Ԯ��
                    amount[i] = amount[newP] + teams[i]; 
					//�����˸��£���i�����·����ĿΪnewp�����·����Ŀ
                    shortestPathCount[i] = shortestPathCount[newP];  
                }  
				//���previous��start->i��������ȣ��������·��
                else if (dist[i] == dist[newP] + mp[newP][i]){  
                         shortestPathCount[i] += shortestPathCount[newP];  
                         if (amount[i] < amount[newP] + teams[i])  
                             amount[i] = amount[newP] + teams[i];  
                      }  
            }  
        }     
        int distmin = Integer.MAX_VALUE;  
		//����һ��״̬���º�Ѱ��dist��С����һ���ڵ㡣���i�Ѿ������Ӽ������ٿ��ǡ�
        for (int i = 0; i < n; i++){  
 
			if (mark[i] == false && dist[i] <distmin){  
                distmin = dist[i];  
                newP = i;  
            }  
        }  
		//set mark[] true,before���ʽڵ�newP����ʱ�ýڵ��Ժ��ٷ��ʣ�״̬Ҳ���ٸı䡣
        mark[newP] = true;  
    }  
 } 
 

 public static void  main(){  
 
    scanf("%d%d%d%d", &n, &m, &start, &en);  
    for (int i = 0; i < n; i++){  
        scanf("%d", &teams[i]);  
    }  
    for (int i = 0; i < n; i++){  
        dist[i] = INF;  
        shortestPathCount[i] = 1;  
        mark[i] = false;  
        for (int j = 0; j < n; j++)  
            mp[i][j] = INF;  
    }  
    for (int i = 0; i < m; i++){  
        int c1, c2, L;  
        scanf("%d%d%d", &c1, &c2, &L);  
        mp[c1][c2] = mp[c2][c1] = L;  
    }  
    dijkstra(start);  
    printf("%d %d\n", shortestPathCount[en], amount[en]);  
    return 0;  
}  
}


