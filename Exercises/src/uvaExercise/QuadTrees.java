package uvaExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuadTrees {

	

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int numberCases = Integer.parseInt(bf.readLine());
		String answer = "";
		while (numberCases > 0) {
			Nodo image1 = new Nodo();
			readString(bf.readLine(), image1, 0);
			Nodo image2 = new Nodo();
			readString(bf.readLine(),image2, 0);
			
			Nodo newImage = new Nodo();
			plusImages(image1,image2,newImage);
			
			
			answer+= "There are "+ sumFillPixel(newImage)+" black pixels.\n";
			numberCases--;
		}
		System.out.print(answer);
	}
	
	public static int sumFillPixel(Nodo root)
	{
		if(root.getId()== 'f')
		{
			if(root.getLvl()!=0) {
			return (int)  (1024/Math.pow(4, root.getLvl()));
			}else 
			{
				return  1024;
			}
		}else if(root.getId()== 'p') {
			int acumulate= 0;
			for (int i = 0; i < root.getNod().length; i++) {
				acumulate =  acumulate +sumFillPixel(root.getNod()[i]);
			}
			return acumulate;
		}
			
		return  0;
		
	}
	
	public static void plusImages(Nodo root1, Nodo root2, Nodo nodeNewImage)
	{
		if(root1.getId()=='f' || root2.getId()=='f')
		{
			nodeNewImage.setId('f');
			nodeNewImage.setLvl(root1.getLvl());
		}else if(root1.getId()== 'p' && root2.getId()== 'e') {
			nodeNewImage.setId(root1.getId());
			nodeNewImage.setLvl(root1.getLvl());
			nodeNewImage.setNod(root1.getNod());
		}else if(root2.getId()== 'p' && root1.getId()== 'e')
		{
			nodeNewImage.setId(root2.getId());
			nodeNewImage.setLvl(root2.lvl);
			nodeNewImage.setNod(root2.getNod());
		}else if(root1.getId()== 'p' && root2.getId()== 'p')
		{
			nodeNewImage.setId('p');
			nodeNewImage.setLvl(root1.getLvl());
			for (int i = 0; i < root1.getNod().length; i++) {
				
				nodeNewImage.getNod()[i] = new Nodo();
				plusImages(root1.getNod()[i], root2.getNod()[i], nodeNewImage.getNod()[i]);
			}
		}else {
			nodeNewImage.setId('e');
			nodeNewImage.setLvl(root1.getLvl());
		}
	}

	public static String readString(String cadena, Nodo root, int level) {
		if (cadena == null || cadena.isEmpty()) {
			return cadena;
		} else {
			char val = cadena.charAt(0);
			cadena = cadena.substring(1);
			if (val == 'p') {
				root.setId('p');
				root.setLvl(level);
				Nodo[] sons = root.getNod();
				for (int i = 0; i < sons.length; i++) {
					Nodo son = new Nodo();
					root.getNod()[i] = son;
					cadena = readString(cadena, sons[i], level + 1);
				}
			} else {

				root.setId(val);
				root.setLvl(level);

				return cadena;
			}
		}
		return cadena;
	}

	public static class Nodo {
		private char id;
		private int lvl;
		private Nodo[] nod;

		public Nodo() {
			setNod(new Nodo[4]);
		}

		public char getId() {
			return id;
		}

		public void setId(char id) {
			this.id = id;
		}

		public int getLvl() {
			return lvl;
		}

		public void setLvl(int lvl) {
			this.lvl = lvl;
		}

		public Nodo[] getNod() {
			return nod;
		}

		public void setNod(Nodo[] nod) {
			this.nod = nod;
		}
	}

}
