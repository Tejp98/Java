
// Question : Validate IP Address


// Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

// IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

// Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

// IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

// However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

// Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

// Note: You may assume there is no extra space or special characters in the input string.

// Example 1:
// Input: "172.16.254.1"

// Output: "IPv4"

// Explanation: This is a valid IPv4 address, return "IPv4".
// Example 2:
// Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

// Output: "IPv6"

// Explanation: This is a valid IPv6 address, return "IPv6".
// Example 3:
// Input: "256.256.256.256"

// Output: "Neither"

// Explanation: This is neither a IPv4 address nor a IPv6 address.



//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.

//Long Solution

import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    public String validIPAddress(String IP) {
        int dot =0,colon=0;
        for(int i =0;i<IP.length();i++){
            if(IP.charAt(i) == '.'){
                dot++;
            }
            else if(IP.charAt(i) == ':'){
                colon++;
            }
        }
        if(dot>3 || colon > 7){
            return "Neither";
        }
        
        String[] v4 = IP.split("\\.");
        String[] v6 = IP.split(":");
        if(v4.length == 4){
            for(int i=0;i<v4.length;i++){
                if(!checkIPv4(v4[i])){
                    return "Neither";
                }
            }
            return "IPv4";
        }
        else if(v6.length == 8){
            for(int i=0;i<v6.length;i++){
                if(!checkIPv6(v6[i])){
                    return "Neither";
                }
            }
            return "IPv6";
        }
        else{
            return "Neither";
        }
    }
    public boolean checkIPv4(String partIP){
        try{
                    if(partIP.length()>1 && partIP.charAt(0) == '0' ){
                    
                    return false;
                }
            else if(partIP.charAt(0) <= '/'  || partIP.charAt(0) >= ':'  ){
                return false;
            }
                else if(partIP.length() > 3 || Integer.parseInt(partIP) >255 || Integer.parseInt(partIP)< 0 || partIP.length()==0 ){
                    
                    return false;
        }
        }
        catch(Exception e){
           
            return false;
        }
        return true;
    }
    
    public boolean checkIPv6(String partIP){
        if(partIP.length() >4 || partIP.length() == 0){
            return false;
        }
        
        
        for(int i =0;i<partIP.length();i++){
            if(Character.isDigit(partIP.charAt(i))){
               
            }
            else if(partIP.charAt(i) >= 'A' && partIP.charAt(i) <= 'F'){
                
            }
            else if(partIP.charAt(i) >= 'a' && partIP.charAt(i) <= 'f'){
                
            }
            else{
                return false;
            }
        }
        
        return true;
    }
}


//Short Solution


import java.net.*;
class Solution {
  public String validIPAddress(String IP) {
    try {
      return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6": "IPv4";
    } catch(Exception e) {}
    return "Neither";
  }
}




