/*
 * @author Saurabh Nailwal
 */

package topicModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class ExtractDocuments {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileReader fileReader1 = null;
		BufferedReader bufferedReader1 = null;
		HashMap<Integer, String> wordMap = new HashMap<Integer, String>();
		int wordId = 0;
		String value = "";
		
		//Read in the vocab.nips.txt and store in map	
		String vocabPath = "/home/saurabh/Data/vocab.nips.txt";
		
		try {
			fileReader1 = new FileReader(new File(vocabPath));
			bufferedReader1 = new BufferedReader(fileReader1);
			while((value = bufferedReader1.readLine()) != null){
			wordId++;
			//System.out.println("Word ID : "+wordId+"\tValue : "+ value);
			
			wordMap.put(wordId, value);	
			//System.out.println("WordMap: "+ wordMap.get(wordId));
			}
			//System.out.println("Total in map: "+wordId); 
			
			bufferedReader1.close();
			fileReader1.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Read the docword.nips.txt and from the documents
		String docwordPath = "/home/saurabh/Data/docword.nips.txt";	
		String outPath = "/home/saurabh/Data/ExtractedDocs/";
		
		FileReader fileReader2 = null;
		BufferedReader bufferedReader2 = null;
		
	        String[] splits = null;
		int docId=0,count=0;
		wordId=0;
		String word ="";
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		
	    try {
						
			fileReader2 = new FileReader(new File(docwordPath));
			bufferedReader2 = new BufferedReader(fileReader2);
			while((value = bufferedReader2.readLine()) != null){
				
				System.out.println("line :"+ value);
				splits = value.split(" ");
				if(splits.length == 3){
					
					//for readability
					docId = Integer.parseInt(splits[0]);
					wordId = Integer.parseInt(splits[1]);
					count = Integer.parseInt(splits[2]);
					
					word = wordMap.get(wordId);
					System.out.println("word: "+ word);
					
					//Writing words into different documents
					fileWriter = new FileWriter(outPath + "Doc"+docId+".txt",true);
					bufferedWriter = new BufferedWriter(fileWriter);
					
					for(int i=0;i<count;i++){
						bufferedWriter.write( word+" ");
					}
					
					//bufferedWriter.flush();
					bufferedWriter.close();
					fileWriter.close();
				}
				
			}			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			if(fileReader1 != null){
				try {
					fileReader1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fileReader2 != null){
				try {
					fileReader2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fileWriter != null){
				try {
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bufferedReader1 != null){
				try {
					bufferedReader1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bufferedReader2 != null){
				try {
					bufferedReader2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bufferedWriter != null){
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
			
		}

	}

}
