package myProject.eth.redis.util.cluster;

import java.util.TreeSet;

public interface IRedisOperator {  
 
    TreeSet<String> keys(String pattern);  
}  
