import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Target Interface
interface MathsProcessing {
    public void mathBasicFunction(String type, Integer[] data);
}


//Adaptee Class
class AdvancedMathProcessing {
    public void calculateAverage(List<Integer> ls) {
        double sum = 0;
        for (int i = 0; i < ls.size(); i++) {
            sum += ls.get(i);
        }
        System.out.println("THe average for the list is : " + (sum / ls.size()));
    }


    public void sortData(List<Integer> ls) {
        Collections.sort(ls);
        System.out.print("The Sorted lISt is :");
        for (int i = 0; i < ls.size(); i++) {
            System.out.print(ls.get(i) + " ");
        }
        System.out.println();
    }

    public void searchData(List<Integer> ls, int data) {
        int flag = 0, ind = 0;
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i) == data) {
                flag = 1;
                ind = i;
                break;
            }
        }
        if (flag == 1) {
            System.out.println("THE ELEMENT IS PRESENT IN THE LIST  and at index : " + ind);
        } else {
            System.out.println("Sorry The Element is not present in the List.");
        }
    }


    public void SumArr(Integer[] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        System.out.println("The Sum of the elements of array is :" + sum);
    }

    public void Multiply(Integer[] data) {
        int mul = 1;
        for (int i = 0; i < data.length; i++) {
            mul *= data[i];
        }
        System.out.println("The Multiplication of the elements of array is :" + mul);
    }


}


//Adapter Class
class MathProcessingAdapter implements MathsProcessing {
    AdvancedMathProcessing amp = new AdvancedMathProcessing();

    @Override
    public void mathBasicFunction(String type, Integer[] data) {
        List<Integer> ls = Arrays.asList(data);
        if (type.equalsIgnoreCase("sort")) {
            amp.sortData(ls);

        } else if (type.equalsIgnoreCase("search")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the element to search : ");
            int a = sc.nextInt();
            amp.searchData(ls, a);


        } else if (type.equalsIgnoreCase("sum")) {
            amp.SumArr(data);
        } else if (type.equalsIgnoreCase("multiply")) {
            amp.Multiply(data);
        } else if (type.equalsIgnoreCase("avg")) {
            amp.calculateAverage(ls);
        } else {
            System.out.println("Wrong Operation Entered....");
        }
    }
}


//Basic Math Functionality
class BasicMathProcessing implements MathsProcessing {
    @Override
    public void mathBasicFunction(String type, Integer[] data) {

        MathProcessingAdapter mpa = new MathProcessingAdapter();
        mpa.mathBasicFunction(type, data);

        //Without Adapter Method Implementation
//        if(type.equalsIgnoreCase("plus")){
//            int sum=0;
//            for (int i = 0; i < data.length; i++) {
//                sum+=data[i];
//            }
//            System.out.println("The sum of your Array Elements is :" +sum);
//        }
//
//        else if(type.equalsIgnoreCase("multiply")){
//            int mul=1;
//            for (int i = 0; i < data.length; i++) {
//                mul*=data[i];
//            }
//            System.out.println("The Multiplication of your Array Elements is :" +mul);
//        }
    }
}

class Mathtesting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MathsProcessing bmp = new BasicMathProcessing();

        System.out.print("Enter The size of Array : ");
        int size = sc.nextInt();
        Integer[] arr = new Integer[size];
        System.out.print("Enter the elements of Array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        bmp.mathBasicFunction("sum", arr);
        bmp.mathBasicFunction("multiply", arr);
        bmp.mathBasicFunction("sort", arr);
        bmp.mathBasicFunction("avg", arr);
        bmp.mathBasicFunction("search", arr);


    }
}