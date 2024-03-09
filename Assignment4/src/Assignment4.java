/*
Marek Judka
CPSC 24500-001
Assignment 4
3-8-24
 */

import java.util.Scanner;
import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Assignment4
{
    /**
     *
     * @param filename
     * @return number of lines in a text file
     * @throws Exception
     */

    //gets numbers of lines
    public static int getNoLines(String filename) throws Exception{
        try (Stream<String> fileStream = Files.lines(Paths.get(filename))) {
            return (int) fileStream.count();
        }
    }

    /**
     *
     * @param filename source file
     * @return two dim array (jagged array), where each row in the array contains the values in one line of the file,
     * the length of each row depends on the number of values in each line of the file.
     * @throws Exception
     */
    //creates the array
    public static int[][] create2DArray(String filename) throws Exception
    {
        //reading file
        try (Scanner scanner = new Scanner(new File(filename)))
        {
            int numOfLines = getNoLines(filename);
            int[][] result = new int[numOfLines][];
            int lineIndex = 0;
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                //splitting lines
                String[] numbers = line.split(" ");
                int[] row = new int[numbers.length];
                //filling array
                for (int i = 0; i < numbers.length; i++)
                {
                    row[i] = Integer.parseInt(numbers[i]);
                }
                result[lineIndex++] = row;
            }
            return result;
        }
    }


    //finding longest row
    public static int findLongestRow(int[][] arr)
    {
        int longestRow = 0;
        int maxLength = arr[0].length;
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i].length > maxLength)
            {
                maxLength = arr[i].length;
                longestRow = i;
            }
        }
        return longestRow;
    }


    //finding largest value in the row
    public static int findMaxInRow(int[][] arr, int rowIndex)
    {
        int max = Integer.MIN_VALUE;
        for (int num : arr[rowIndex])
        {
            if (num > max)
            {
                max = num;
            }
        }
        return max;
    }


    //finding the max value
    public static int findMax(int[][] arr)
    {
        int max = Integer.MIN_VALUE;
        for (int[] row : arr)
        {
            for (int num : row)
            {
                if (num > max)
                {
                    max = num;
                }
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        String filename = null;
        if (args.length <1)
        {
            System.out.println("usage: Assignment4 inputFilename ");
            System.exit(0);

        }
        filename = args[0];
        int arr[][] = null;
        try {
            System.out.println("Number of lines in the file ="+ getNoLines(filename));
            arr = create2DArray(filename);
            int longestRow = findLongestRow(arr);
            System.out.println("Longest row in the file is: "+ (longestRow+1 )+" ,with length of: "
                    +arr[longestRow].length);
            System.out.println("Max value in first row = "+ findMaxInRow(arr, 0));
            System.out.println("Max value in file = "+ findMax(arr));
        } catch (Exception e)
        {
            System.out.print(e);
        }
    }
}
