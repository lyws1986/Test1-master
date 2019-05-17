package com.example.xiaoye.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;


public class Socket_Tool{
	Context c;
    static SQLiteDatabase db;
    

	public Socket_Tool(Context c){
		
		this.c=c;
		 db = SQLiteDatabase.openOrCreateDatabase(c.getFilesDir().toString() + "/my.db3" , null);

	}
	
	
	 public static  String  order(int size,String  d_total,String plu[],String weight[],String d_prize[],String e_total[],String name[],
			 String unit[],String pay,String card_num,String pwd,String cash,String card_money, double[] jifen,String[] ysprize,
			 String[]rate,String buy_physics_01,String buy_physics_02,String cargo_num[],String pichi[],String index,String weiyima,
			 String balance_num,String mc){

		  final Calendar c = Calendar.getInstance();
		  c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
		  String mYear = String.valueOf(c.get(Calendar.YEAR)); // ��ȡ��ǰ���
		  String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// ��ȡ��ǰ�·�
		  String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// ��ȡ��ǰ�·ݵ����ں���
		  String mHour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));//ʱ
		  String mMinute = String.valueOf(c.get(Calendar.MINUTE));//��
		  String mSecond = String.valueOf(c.get(Calendar.SECOND));//��
		  String s=new SimpleDateFormat("yyyyMMddHHmmss").format(c.getTime());
		 String ops="";
		 System.out.println("�ܹ�����"+size+"��Ʒ");
		 for(int i=0;i<size;i++){
		 ops+="RES\t"+weiyima+"\t"+index+"\t"+e_total[i]+"\t"+plu[i]+"\t"+"3"+"\t"+"4"+"\t"+"0,2"+"\t"+weight[i]+"\t"+unit[i]+"\t"+"0"+"\t"
		 +Double_Number.NetString(Double.parseDouble(rate[i]))+"\t"+ysprize[i]+"\t"+d_prize[i]+"\t"+name[i]+"\t"
		 +Double_Number.NetString(jifen[i])+"\t"+cargo_num[i]+"\t"+pichi[i]+"\t\r\n";// +cargo_num[i]+"\t"+pichi[i]+"\t\r\n";
		  }
		
	    final String payment=
	   "DWL\tREP\t"+s+"\t"+index+"\t"+mc+"\t\r\n"
	   +"REP\t"+weiyima+"\t" +mYear.substring(2, mYear.length())+"\t"+mMonth+"\t"+mDay+"\t"+mHour+"\t"+mMinute+"\t"+mSecond+"\t"+index+"\t"
	   +index+"\t"+"0"+"\t"+card_num+"\t"+pwd+"\t"+d_total+"\t"+cash+"\t"+card_money+"\t"+"0"+"\t"+"0"+"\t"+"0"+"\t"+"0,2"+"\t"+"0,2"+"\t"
	   +pay+"\t"+"0"+"\t"+""+"\t"+""+"\t"+"0,0"+"\t"+"0,0"+"\t"+""+"\t"+"2"+"\t"+buy_physics_01+"\t"+buy_physics_02+"\t"//physics_card_long[0]
			 +"0"+"\t"+"0"+"\t\r\n" //"\t"+physics_card_long[0]+"\t"+physics_card_long[1]+"\t"+"0"+"\t"+"0"+
	   + ops
	   + "REE\t"+weiyima+"\t\r\n"
	   + "END\tREP\t"+s+"\t"+index+"\t"+weiyima+"\t"+mc+"\t\r\n";

	  return payment;
		  }
		
	 
	//��������
	 public void isData(SQLiteDatabase db,int contract,
	 String  size,String d_total,String  plu[],String weight[],String d_prize[],String e_total[],String name[],
	 String unit[],String pay,String card_num,String pwd,String cash,String card_money,double[] jifen,
	 String[] ysprize,String[] rate,String buy_physics_01,String buy_physics_02,String cargo_num[],String pichi[]){	
	 	try{
	 		String  plu1="", weight1="", d_prize1="", e_total1="", name1="", unit1="", jifen1="", ysprize1="", rate1="",
	 				cargo_num1="",pichi1="";	
	 		
	 		for(int a=0;a<Integer.parseInt(size);a++){
	 			plu1+=plu[a]+"/";
	 			weight1+=weight[a]+"/";
	 			d_prize1+=d_prize[a]+"/";
	 			e_total1+=e_total[a]+"/";
	 			name1+=name[a]+"/";
	 			unit1+=unit[a]+"/";	
	 	
	 			jifen1+=jifen[a]+"/";	
	 			ysprize1+=ysprize[a]+"/";	
	 			rate1+=rate[a]+"/";
	 			cargo_num1+=cargo_num[a]+"/";
	 			pichi1+=pichi[a]+"/";
	 			
	 		System.out.println("rate1[a]  "+rate1);
	 		}
	 	
//	 		System.out.println("plu1  "+plu1);
//	 		System.out.println("weight1  "+weight1);
//	 		System.out.println("d_prize1  "+d_prize1);
	 		//ִ�в������
	 		db.execSQL("insert into erp values(?,?,?,?,?,?,?,?,?"+ ",?,?,?,?,?,?,?,?,?,?,?,?)"
	 		 , new Object[]{contract,size,d_total,plu1,weight1,d_prize1,e_total1,name1,unit1,pay,card_num,
	 			 	pwd,cash,card_money ,jifen1, ysprize1,rate1,buy_physics_01,buy_physics_02,cargo_num1,pichi1
	 });
	 		
	 		System.out.println("����ɹ�");
	        //Search_Data();

	 	}
	 	
	 	catch(SQLiteException  se)
	 	{
	 		System.out.println("����ʧ��");
	 	}
	 	}

}
