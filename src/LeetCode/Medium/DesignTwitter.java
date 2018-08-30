package src.LeetCode.Medium;

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
    
    //ÿ���˰l������Ϣ(�Ñ�ID, tweet)
    HashMap<Integer, List<Tweet>> timelines;
    
	//set�e���ŵă��ݶ�������ͬ����ʹ�����������Ñ�׷ۙĳ�Ñ�
    //�o����H�P�S(�Ñ�ID, ���Ñ�����׷ۙ���Ñ�IDs)
    HashMap<Integer, HashSet<Integer>> relation;
    
    /** Initialize your data structure here. */
    //��ʼ��
    public Twitter() {
        this.timelines = new HashMap<Integer, List<Tweet>>();
        this.relation = new HashMap<Integer, HashSet<Integer>>();
    }
    
    //poһ����tweet
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	//���]��ԓ�Ñ�t����һ��
        if(timelines.containsKey(userId) == false) {
        	timelines.put(userId, new ArrayList<Tweet>());
        }
        
        //�M��po tweet�Ą���
        timelines.get(userId).add(new Tweet(tweetId, timeStampCounter));
        timeStampCounter ++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    //��ÿ��׷ۙ���Ñ�ȡ��10��(�����Լ�Ҳȡ��10��)tweet���ٌ�����ȡ����tweet����������
    //��θ�ȡ��10��������Ñ����ܕ��B�m�l��10���µ�����
    public List<Integer> getNewsFeed(int userId) {
    	//�����Ñ���׷ۙ�������Ñ�ȡ��
    	HashSet<Integer> followees = relation.get(userId);
    	
    	//�Á��ź��x��tweet
    	List<Tweet> candiciates = new ArrayList<Tweet>();
    	
    	//ȡ���Լ�post��tweet
		List<Tweet> userTimeline = timelines.get(userId);
    	if(userTimeline != null) {
    		int lowerBound = Math.max(0, userTimeline.size() - 10);
    		for(int i = userTimeline.size() - 1; i >= lowerBound; i--) {
    			candiciates.add(userTimeline.get(i));
    		}
    	}
    	
    	//ȡ������׷ۙ���Ñ�����post��tweet
    	if(followees != null) {
    		for(Integer followee : followees) {
    			List<Tweet> followeeTimeline = timelines.get(followee);
    			
    			//�����Ñ��]�аl���κε�tweet���t���^
    			if(followeeTimeline == null)
    			    continue;
    			    
    			int lowerBound = Math.max(0, followeeTimeline.size() - 10);
    			for(int i = followeeTimeline.size() - 1; i >= lowerBound; i--) {
        			candiciates.add(followeeTimeline.get(i));
        		}
    		}
    	}
    	
    	//������tweet�M�������ԕr�g�����
    	Collections.sort(candiciates, new Comparator<Tweet>() {
			@Override
			public int compare(Tweet t1, Tweet t2) {
				// TODO Auto-generated method stub
				return t2.timeStamp - t1.timeStamp;
			}
    	});
    	
    	//�����µ�10�P�Y��ݔ��
    	List<Integer> result = new ArrayList<Integer>();
    	int upperBound = Math.min(10, candiciates.size());
    	for(int i = 0; i < upperBound; i++ ) {
    		result.add(candiciates.get(i).tweetId);
    	}
    	
    	return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    //����׷ۙ�Ñ�
    public void follow(int followerId, int followeeId) {
        //��ֹ�Լ�׷ۙ�Լ�
    	if(followerId == followeeId)
        	return;
    	
    	//���]���ҵ����Ñ�t����һ��
    	if(relation.containsKey(followerId) == false) {
    		relation.put(followerId, new HashSet<Integer>());
    	}
    	
    	//�M��׷ۙ�Ą���
    	relation.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    //������׷ۙ�Ñ�
    public void unfollow(int followerId, int followeeId) {
    	//ȡ��ԓ�Ñ����е�׷ۙ���Ñ�
    	HashSet<Integer> followees = relation.get(followerId);
    	
    	//��ԓ�Ñ��]��׷ۙ�κ��˄t�x�_
    	if(followees == null)
    		return;
    	
    	//�M��ȡ��׷ۙ�Ą���
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