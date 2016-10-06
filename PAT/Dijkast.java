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
    //start->s的距离
	dist[s] = 0;  
    amount[s] = teams[s];  
    
	
	//从start开始
    int newP = s;  
    mark[s] = true;  
	//寻找enmegency：寻找到该节点，停止循环。
    while (newP != enmegrgency){  
		//研究节点newp旁边的i节点，更新最短距离dist【】和最短路线数目pathcount
        for (int i = 0; i < n; i++){  
			//如果mark为false，访问i节点。防止出现环
            if (mark[i] == false){  
				//如果previous的start->i大于现在
                if (dist[i] > dist[newP] + mp[newP][i]){  
                    dist[i] = dist[newP] + mp[newP][i];
					//gather该市的救援队
                    amount[i] = amount[newP] + teams[i]; 
					//发生了更新，到i的最短路径数目为newp的最短路径数目
                    shortestPathCount[i] = shortestPathCount[newP];  
                }  
				//如果previous的start->i和现在相等，新增最短路径
                else if (dist[i] == dist[newP] + mp[newP][i]){  
                         shortestPathCount[i] += shortestPathCount[newP];  
                         if (amount[i] < amount[newP] + teams[i])  
                             amount[i] = amount[newP] + teams[i];  
                      }  
            }  
        }     
        int distmin = Integer.MAX_VALUE;  
		//经历一轮状态更新后，寻找dist最小的下一个节点。如果i已经加入子集，不再考虑。
        for (int i = 0; i < n; i++){  
 
			if (mark[i] == false && dist[i] <distmin){  
                distmin = dist[i];  
                newP = i;  
            }  
        }  
		//set mark[] true,before访问节点newP。此时该节点以后不再访问，状态也不再改变。
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


