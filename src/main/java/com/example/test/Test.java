package com.example.test;

import java.rmi.RemoteException;

import com.example.LoginService;
import com.example.LoginServiceProxy;

public class Test {
	/** 
     * 利用axis调用webservice实例 
     * @param args 
     */  
    public static void main(String[] args) {  
          
        try {  
            //换成对应的proxy类  
            LoginServiceProxy proxy = new LoginServiceProxy();  
            //web service提供的wsdl地址
            proxy.setEndpoint("http://localhost:8080/WebServiceServer/services/LoginService");  
            //换成获取对应的serice  
            LoginService loginService = proxy.getLoginService();  
            //调用web service提供的方法  
            int result = loginService.checkUserRight("fred","w");  
              
            System.out.println(result);  
              
        } catch (RemoteException e) {  
            e.printStackTrace();  
        }  
  
    }  
}
