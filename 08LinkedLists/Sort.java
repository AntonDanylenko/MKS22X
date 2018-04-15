public class Sort{
    public static void radixsort(MyLinkedListImproved<Integer> data){
        for (int n=0; n<(data.get(0) + "").length(); n++){
            digitsort(data, n);
        }
    }

    public static void digitsort(MyLinkedListImproved<Integer> data, int digit){
        Integer[] digits= {0,1,2,3,4,5,6,7,8,9};
        System.out.println(data + ", " + digit);
        for (int n=0; n<data.size(); n++){
            Integer num = (data.get(n) / Integer.valueOf((int)Math.pow(10, digit))) % 10;
            System.out.println(num);
        }
    }

    public static void main(String[]args){
	MyLinkedListImproved<Integer> list = new MyLinkedListImproved<Integer>();
	list.add(745);
	list.add(523);
	list.add(109);
	System.out.println(list);
    radixsort(list);
    System.out.println(list);
    }
}