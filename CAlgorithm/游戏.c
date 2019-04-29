/*
 * 有一天，小A和小B玩了一个神奇的游戏，游戏开始时，桌面上有a0个不同的盒子和bo个不同的物品。每个回合，两个人可以选择增加一个新的盒子和b0个
 * 不同的物品（所有物品和盒子不同），记得前桌子上的盒子数量为a，物品数量为b，当把b个物品放入a的盒子的方案数不小于n时，游戏结束，此时随后
 * 一个操作者判负。
 * 给出a0，b0，n，如果小A先手，两个人采取最优策略，谁能获胜，如果A获取输入“A”，如果B获胜，输出“B”，如果是平局，输出“A&B”。
 *
 */
#include<stdio.h>
#include<math.h>
int main (){
	int T;
	scanf("%d", &T);
	while(T--){
		int a, b;
		long long n, res = 0, r1, r2, t = 0;
		scanf("%d %d %lld", &a, &b, &n);
		if(a == 1) {
			printf("A&B\n");
			continue;
		}
		while(res < n){
			r1 = pow(a + 1, b);
			r2 = pow(a, b + 1);
			t++;
			if(r1 > r2){
				res = r2;
				b ++;
			}else if(r1 == r2){
				res = r2;
				a ++;
			}else{
				res = r1;
				b ++;
			}
		}
		if(t % 2){
			printf("A\n");
		}else{
			printf("B\n");
		}
	}
}
