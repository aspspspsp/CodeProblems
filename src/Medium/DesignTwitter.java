package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DesignTwitter {
public class Twitter {
    class Tweet {
        int tweetId;
        int timeStamp;
        public Tweet(int tweetId, int timeStamp) {
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }
    }
    
    int timeStampCounter;
    
    //每個人發布的消息(用戶ID, tweet)
    HashMap<Integer, List<Tweet>> timelines;
    
	//set裡面存放的內容都不會相同，故使用它來作為用戶追蹤某用戶
    //紀錄人際關係(用戶ID, 此用戶正在追蹤的用戶IDs)
    HashMap<Integer, HashSet<Integer>> relation;
    
    /** Initialize your data structure here. */
    //初始化
    public Twitter() {
        this.timelines = new HashMap<Integer, List<Tweet>>();
        this.relation = new HashMap<Integer, HashSet<Integer>>();
    }
    
    //po一個新tweet
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	//若沒有該用戶則新增一個
        if(timelines.containsKey(userId) == false) {
        	timelines.put(userId, new ArrayList<Tweet>());
        }
        
        //進行po tweet的動作
        timelines.get(userId).add(new Tweet(tweetId, timeStampCounter));
        timeStampCounter ++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    //對每個追蹤的用戶個取出10個(包含自己也取出10個)tweet，再將所有取出的tweet再另作排序
    //為何各取出10個，因為用戶可能會連續發出10最新的文章
    public List<Integer> getNewsFeed(int userId) {
    	//將此用戶所追蹤的所有用戶取出
    	HashSet<Integer> followees = relation.get(userId);
    	
    	//用來存放候選的tweet
    	List<Tweet> candiciates = new ArrayList<Tweet>();
    	
    	//取出自己post的tweet
		List<Tweet> userTimeline = timelines.get(userId);
    	if(userTimeline != null) {
    		int lowerBound = Math.max(0, userTimeline.size() - 10);
    		for(int i = userTimeline.size() - 1; i >= lowerBound; i--) {
    			candiciates.add(userTimeline.get(i));
    		}
    	}
    	
    	//取出所有追蹤的用戶最新post的tweet
    	if(followees != null) {
    		for(Integer followee : followees) {
    			List<Tweet> followeeTimeline = timelines.get(followee);
    			
    			//若此用戶沒有發表任何的tweet，則跳過
    			if(followeeTimeline == null)
    			    continue;
    			    
    			int lowerBound = Math.max(0, followeeTimeline.size() - 10);
    			for(int i = followeeTimeline.size() - 1; i >= lowerBound; i--) {
        			candiciates.add(followeeTimeline.get(i));
        		}
    		}
    	}
    	
    	//對所有tweet進行排序，以時間戳為準
    	Collections.sort(candiciates, new Comparator<Tweet>() {
			@Override
			public int compare(Tweet t1, Tweet t2) {
				// TODO Auto-generated method stub
				return t2.timeStamp - t1.timeStamp;
			}
    	});
    	
    	//將最新的10筆結果輸出
    	List<Integer> result = new ArrayList<Integer>();
    	int upperBound = Math.min(10, candiciates.size());
    	for(int i = 0; i < upperBound; i++ ) {
    		result.add(candiciates.get(i).tweetId);
    	}
    	
    	return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    //實作追蹤用戶
    public void follow(int followerId, int followeeId) {
        //防止自己追蹤自己
    	if(followerId == followeeId)
        	return;
    	
    	//若沒有找到此用戶則新增一個
    	if(relation.containsKey(followerId) == false) {
    		relation.put(followerId, new HashSet<Integer>());
    	}
    	
    	//進行追蹤的動作
    	relation.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    //實作不追蹤用戶
    public void unfollow(int followerId, int followeeId) {
    	//取得該用戶所有的追蹤的用戶
    	HashSet<Integer> followees = relation.get(followerId);
    	
    	//若該用戶沒有追蹤任何人則離開
    	if(followees == null)
    		return;
    	
    	//進行取消追蹤的動作
    	followees.remove(followeeId);
    }
}
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */