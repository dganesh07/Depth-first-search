import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class Depth_Search {
	static int root = 0;

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		Traverse();

	}

	public static void Traverse() throws IOException, Exception {

		Stack S = new Stack();

		int matrix[][] = getMatrix();
		int mLeng = matrix[0].length;

		int[] Visited = new int[mLeng];
		// push the first node into the stack!
		S.push(root); // 0 is my first node!!
		Visited[root] = 1;
		System.out.println(root);
		// System.out.println(matrix.length);

		while (S.isEmpty() == 0) {
			int n, child;
			n = (S.peek());
			child = getChild(n, matrix, Visited);
			if (child != -1) {
				Visited[child] = 1;
				System.out.println(child);
				S.push(child);
			} else {
				S.pop();
			}

		}
	}

	static int getChild(int n, int[][] matrix, int[] Visited) {
		int j;

		for (j = 0; j < matrix.length; j++) {
			if (matrix[n][j] > 0) {
				if (Visited[j] != 1)
					return (j);
			}
		}

		return (-1);
	}

	public static int[][] getMatrix() throws IOException, Exception {

		int row = 0;
		int column = 0;
		String curLine[] = null;
		BufferedReader br = null;

		// Enter the file name that is in the directory!!
		System.out.println("Enter file name: ");
		Scanner sc = new Scanner(System.in);
		String file = sc.next();

		try {

			br = new BufferedReader(new FileReader(file));
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				row++;
				curLine = currentLine.split("\\s");
				column = curLine.length;

			}
			int matrix[][] = new int[row][column];
			br.close();
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("File was not found!Please Enter the correct file name!!");
			main(null);
			System.out.println();
		} catch (IOException ioe) {
			System.out.println("Some thing wrong!!!!.");
			main(null);
			System.out.println();
		}

		return storeMatrix(file, row, column);
	}

	// to store the matrix that has been read by the file
	public static int[][] storeMatrix(String txtFile, int row, int column) throws IOException {

		int tempRow = 0;
		String newCurrentLine;
		BufferedReader br1 = null;
		int matrix[][] = new int[row][column];

		br1 = new BufferedReader(new FileReader(txtFile));

		while ((newCurrentLine = br1.readLine()) != null) {
			String newLine[] = newCurrentLine.split("\\s");

			for (int i = 0; i < column; i++) {
				// converting string in file to integer!!!!
				matrix[tempRow][i] = Integer.parseInt(newLine[i]);
			}
			tempRow++;
		}

		br1.close();

		return matrix;

	}

}
