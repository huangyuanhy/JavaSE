package test;

import java.awt.*;
import java.awt.List;
import java.util.*;

public class ShowHand {
	//������Ϸ֧���������
	private final int PLAYNUM=5;
	//�����˿˵Ļ�ɫ����ֵ�������ĸ��������ַ�������ӡ�����顣�ݻ������ģ�����
	private String[] types= {"\4","\5","\3","\6"};
	private String[] values= {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	
	//card��һ����Ϸ��ʣ�µ��˿���
	private List cards=new List();
	//�������Ե����
	private String[] players=new String[PLAYNUM];
	//����������ҵ��˿���
	private List[] playCards=new List[PLAYNUM];
	/**
	 * ��ʼ���˿��ƣ�����52�ţ������������
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
	 * ��ʼ����ң��������û���
	 */
	public void initPlayers() {
		
	}
}
