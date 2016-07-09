package noman_temp;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akhtar
 */
public class compressname {
    static compressname cn;
    public static compressname Objectcreator()
    {
    if(cn==null)
     cn=new compressname();
    return cn;
    }
    
    public static String name_decrease(String name)
    {
        int len=name.length();     
        if(len>15)
        {
        StringBuilder sb=new StringBuilder();
        name=name.substring(0,12);
        sb.append(name);
        sb.append("...");
        name=sb.toString();    
        }
    return name;
    }
     public static String address_decrease(String add)
    {
        int len=add.length();     
        if(len>48)
        {
        StringBuilder sb=new StringBuilder();
        add=add.substring(0,50);
        sb.append(add);
        sb.append("...");
        add=sb.toString();    
        }
    return add;
    }
    
     public static String user_decrease(String user)
    {
        int len=user.length();     
        if(len>40)
        {
        StringBuilder sb=new StringBuilder();
        user=user.substring(0,40);
        sb.append(user);
        sb.append("...");
        user=sb.toString();    
        }
    return user;
    }
    
    public static String topic_decrease(String topic)
    {
        int len=topic.length();     
        if(len>30)
        {
        StringBuilder sb=new StringBuilder();
        topic=topic.substring(0,30);
        sb.append(topic);
        sb.append("...");
        topic=sb.toString();    
        }
    return topic;
    }
    public static String post_decrease(String post)
    {
        int len=post.length();     
        if(len>500)
        {
        StringBuilder sb=new StringBuilder();
        post=post.substring(0,480);
        sb.append(post);
        sb.append("......");
        post=sb.toString();    
        }
    return post;
    }
    
    
}
