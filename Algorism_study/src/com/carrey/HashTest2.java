package com.carrey;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class HashTest2 {
	private int plays_total=0;
	private int plays_index=0;
	private int plays_value=0;
	private ArrayList<HashTest2> indexAndValue;
	
	
	public int[] solution(String[] genres, int[] plays) {
			
	        int[] answer = {};
	        ArrayList<HashTest2> list = null;
	        HashMap<String, HashTest2> hm=new HashMap<>();
	        for(int i=0;i<genres.length;i++) {
	        	if(hm.containsKey(genres[i])) {
	        		HashTest2 ht = new HashTest2();
	        		ht.setPlays_total(hm.get(genres[i]).getPlays_total()+plays[i]);
	        		HashTest2 ht2 = new HashTest2();
	        		if(hm.get(genres[i]).getIndexAndValue().size()<2) {
		        		ht2.setPlays_index(i);
		        		ht2.setPlays_value(plays[i]);
		        		list=hm.get(genres[i]).getIndexAndValue();
		        		list.add(ht2);
		        		ht.setIndexAndValue(list);
	        		}else {
	        			
	        			int size=hm.get(genres[i]).getIndexAndValue().size();
	        			int a=hm.get(genres[i]).getIndexAndValue().get(size-1).getPlays_value();
	        				if(a<plays[i]) {
	    		        		ht2.setPlays_index(i);
	    		        		ht2.setPlays_value(plays[i]);
	    		        		list=hm.get(genres[i]).getIndexAndValue();
	    		        		list.set(size-1,ht2);
	    		        		ht.setIndexAndValue(list);
	        				}
	        		}
	        		hm.put(genres[i], ht);
	        	}else {
	        		HashTest2 ht = new HashTest2();
	        		list=new ArrayList<>();
	        		ht.setPlays_total(plays[i]);
	        		
	        		HashTest2 ht2 = new HashTest2();
	        		ht2.setPlays_index(i);
	        		ht2.setPlays_value(plays[i]);
	        		list.add(ht2);
	        		
	        		ht.setIndexAndValue(list);
	        		hm.put(genres[i], ht);
	        	}
	        	
	        	hm.get(genres[i]).getIndexAndValue().sort(new Comparator<HashTest2>() {
    				@Override
    	        	public int compare(HashTest2 o1, HashTest2 o2) {
    	        		if(o2.getPlays_value()>o1.getPlays_value()) return 1;
    	        		else if(o2.getPlays_value()==o1.getPlays_value()) return 0;
    	        		else return -1;
    	        	};
    			});

	        }
	        ArrayList<HashTest2> result= new ArrayList<>();
	        for(String mapKey : hm.keySet()) {
	        	result.add(hm.get(mapKey));
	        }
	        result.sort(new Comparator<HashTest2>() {
	        	@Override
	        	public int compare(HashTest2 o1, HashTest2 o2) {
	        		if(o2.getPlays_total()>o1.getPlays_total()) return 1;
	        		else if(o2.getPlays_total()==o1.getPlays_total()) return 0;
	        		else return -1;
	        	}
	        });
	        ArrayList<Integer> integer= new ArrayList<>();
	        for(int i=0;i<result.size();i++) {
	        	for(int j=0;j<result.get(i).getIndexAndValue().size();j++) {
	        		integer.add(result.get(i).getIndexAndValue().get(j).getPlays_index());
	        	}
	        }
	        answer=new int[integer.size()];
	        for(int i=0;i<answer.length;i++) {
	        	answer[i]=integer.get(i);
	        }
	        return answer;
	}
	public static void main(String args[]) {
		HashTest2 ht=new HashTest2();
		String []genres= {"classic","pop","classic","classic","pop"};
		int [] plays= {500,600,150,800,2500};
		ht.solution(genres, plays);
	}
	public int getPlays_total() {
		return plays_total;
	}
	public void setPlays_total(int plays_total) {
		this.plays_total = plays_total;
	}
	public ArrayList<HashTest2> getIndexAndValue() {
		return indexAndValue;
	}
	public void setIndexAndValue(ArrayList<HashTest2> indexAndValue) {
		this.indexAndValue = indexAndValue;
	}
	public int getPlays_index() {
		return plays_index;
	}
	public void setPlays_index(int plays_index) {
		this.plays_index = plays_index;
	}
	public int getPlays_value() {
		return plays_value;
	}
	public void setPlays_value(int plays_value) {
		this.plays_value = plays_value;
	}
}
