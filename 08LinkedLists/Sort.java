public class Sort{
    public static void radixsort(MyLinkedListImproved<Integer> data){
        //System.out.println((data.get(0) + "").length());
        for (int n=0; n<(data.get(0) + "").length(); n++){
            digitsort(data, n);
        }
    }

    public static void digitsort(MyLinkedListImproved<Integer> data, int digit){
        MyLinkedListImproved<Integer> zer = new MyLinkedListImproved<Integer>();
        MyLinkedListImproved<Integer> one = new MyLinkedListImproved<Integer>();
        MyLinkedListImproved<Integer> two = new MyLinkedListImproved<Integer>();
        MyLinkedListImproved<Integer> thr = new MyLinkedListImproved<Integer>();
        MyLinkedListImproved<Integer> fou = new MyLinkedListImproved<Integer>();
        MyLinkedListImproved<Integer> fiv = new MyLinkedListImproved<Integer>();
        MyLinkedListImproved<Integer> six = new MyLinkedListImproved<Integer>();
        MyLinkedListImproved<Integer> sev = new MyLinkedListImproved<Integer>();
        MyLinkedListImproved<Integer> eig = new MyLinkedListImproved<Integer>();
        MyLinkedListImproved<Integer> nin = new MyLinkedListImproved<Integer>();
        //MyLinkedListImproved<Integer>[] group = new MyLinkedListImproved<Integer>[]{zer, one, two, thr, fou, fiv, six, sev, eig, nin};
        @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] group = new MyLinkedListImproved[10];
        group[0] = zer;
        group[1] = one;
        group[2] = two;
        group[3] = thr;
        group[4] = fou;
        group[5] = fiv;
        group[6] = six;
        group[7] = sev;
        group[8] = eig;
        group[9] = nin;
        
        //System.out.println(data + ", " + digit);
        for (int n=0; n<data.size(); n++){
            Integer num = (data.get(n) / Integer.valueOf((int)Math.pow(10, digit))) % 10;
            //System.out.println(num);
            group[num].add(data.get(n));
        }

        MyLinkedListImproved<Integer> result = new MyLinkedListImproved<Integer>();
        for (int r=0; r<10; r++){
            result.extend(group[r]);
        }
        //System.out.println(result);
        //System.out.println(data);
        data.clear();
        data.extend(result);
        //System.out.println(data + "aaa");
    }

    public static void main(String[]args){
	MyLinkedListImproved<Integer> list = new MyLinkedListImproved<Integer>();
	list.add(745);
	list.add(523);
	list.add(109);
	list.add(222);
	list.add(931);
	list.add(233);
	System.out.println(list + "ccc");
    radixsort(list);
    System.out.println(list + "bbb");
    }
}