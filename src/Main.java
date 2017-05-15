public class Main {

    public static void main(String[] args) {
        MyTreeSet myTreeSet = new MyTreeSet();
        myTreeSet.insert("привет");
        myTreeSet.insert("проверка");
        myTreeSet.insert("пока");
        myTreeSet.insert("тест");
        myTreeSet.insert("ананас");

        System.out.println(myTreeSet.getSize());
        System.out.println(myTreeSet.contains("ананас"));

        myTreeSet.traverseTree();
        myTreeSet.delete("пока");
        myTreeSet.traverseTree();
    }
}
