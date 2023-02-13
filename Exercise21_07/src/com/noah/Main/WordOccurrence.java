package com.noah.Main;

public class WordOccurrence implements Comparable<WordOccurrence> {
	
	private String word;
	private Integer count;
	
	public WordOccurrence(String word, Integer count) {
		this.word = word;
		this.count = count;
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	@Override
	public int compareTo(WordOccurrence o) {
		
		int returnCode = 0;
		
		if(this.count > o.getCount()) {
			returnCode = 2;
		} else if(this.count == o.getCount()) {
			returnCode = 1;
		}
		
		return returnCode;
	}

}
