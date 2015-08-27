package com.ssthouse.myscenetransitiontest.view.style;


import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;

public class TransparentStyle {

	public static void setTransparentStyle(Context context, int colorResourceID){
		//获取颜色
		int color = context.getResources().getColor(colorResourceID);
		//形成完整沉浸式的方法
		((Activity)context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		SystemBarTintManager tintManager = new SystemBarTintManager((Activity) context);
		tintManager.setStatusBarTintEnabled(true);  
		// 设置一个颜色给系统栏   
		tintManager.setTintColor(color);   
		// 设置一个状态栏资源 
		tintManager.setStatusBarTintColor(color);
	}
}
