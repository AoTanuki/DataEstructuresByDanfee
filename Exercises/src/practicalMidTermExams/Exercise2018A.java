package practicalMidTermExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import danfeeLinearDataEstructures.DanfeeQueue;
import danfeeLinearDataEstructures.DanfeeSimpleLinkedList;
import danfeeLinearDataEstructures.List;

public class Exercise2018A {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int caseNumber = Integer.parseInt(bf.readLine());
		DanfeeSimpleLinkedList<String> outputList = new List<>();

		while (caseNumber > 0) {

			String[] data = bf.readLine().split(" ");

			int cashiersNumber = Integer.parseInt(data[0]);
			int clientNumber = Integer.parseInt(data[1]);

			List<Node>[] list = new List[cashiersNumber];
			DanfeeQueue<Node>[] cashiers = (DanfeeQueue<Node>[]) list;
			
			for (int i = 0; i < cashiers.length; i++) {
				cashiers[i]= (DanfeeQueue<Node>) new List<Node>();
			}
			
			

			int minIndex = -1;

			DanfeeSimpleLinkedList<Integer> fillQueueindexes = new List<>();

			
			while ((clientNumber)> 0) {
				String[] clientData = bf.readLine().split(" ");
				Node newClient = new Node(clientData[0], Integer.parseInt(clientData[1]));

				minIndex =findMinimunQueue(cashiers, minIndex);
				cashiers[minIndex].enQueue(newClient);
				if (!fillQueueindexes.contains(minIndex))
					fillQueueindexes.add(minIndex);
				clientNumber--;
				
			}

			int k = 0;
			
			while (!fillQueueindexes.isEmpty()) {
				k++;
				for (int i = 0; i < fillQueueindexes.size(); i++) {
					Node currentNode =cashiers[fillQueueindexes.get(i)].peek();
					try {
						currentNode.decreaseArticle();
						if(currentNode.getArticles()==0)
						{
							cashiers[fillQueueindexes.get(i)].deQueue();
							outputList.add(currentNode.getId()+" "+ k);
						}
						if(cashiers[fillQueueindexes.get(i)].isEmpty()) {
							fillQueueindexes.remove(i);
							i--;
						}
					} catch (Exception e) {
						try{
							fillQueueindexes.remove(i);
						}catch(Exception ex) {
							System.out.println("el problema fue en "+ i);
						}
						while(cashiers[fillQueueindexes.get(i)].isEmpty())
						{
							i--;
						}
					}
				}
			}
			
			outputList.add(k+ "");
			caseNumber--;
		}
		
		for (int i = 0; i < outputList.size(); i++) {
			System.out.println(outputList.get(i));
		}
	}

	public static int findMinimunQueue(DanfeeQueue<Node>[] queue, int currentIndex) {

		currentIndex++;
		
		if (currentIndex == queue.length) {
			currentIndex = 0;
		}
		
		return currentIndex;
	}

	public static class Node {

		private String id;
		private int articles;

		public Node(String id, int articles) {
			this.id = id;
			this.articles = articles;
		}

		public String getId() {
			return id;
		}

		public int getArticles() {
			return articles;
		}

		public void decreaseArticle() {
			this.articles--;
		}

	}

}
