package test;

import java.awt.*;
import java.awt.List;
import java.util.*;

public class ShowHand {
	//定义游戏支持玩家数量
	private final int PLAYNUM=5;
	//定义扑克的花色和数值，下面四个是特殊字符，将打印出方块。草花，红心，黑桃
	private String[] types= {"\4","\5","\3","\6"};
	private String[] values= {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	
	//card是一句游戏中剩下的扑克牌
	private List cards=new List();
	//定义所以的玩家
	private String[] players=new String[PLAYNUM];
	//定义所有玩家的扑克牌
	private List[] playCards=new List[PLAYNUM];
	/**
	 * 初始化扑克牌，放入52张，并且随机排序
	 * 
	 */
	public void initCards() {
		for (int i=0;i<types.length;i++) {
			for(int j=0;j<values.length;j++) {
				cards.add(types[i]+values[j]);
			}
		}
		Collections.shuffle((java.util.List<?>) cards);
		
	}
	
	/**
	 * 初始化玩家，并分派用户名
	 */
	public void initPlayers() {
		
	}
}
