package ru.geekbrains.lesson_2_7.forExample;


import ru.geekbrains.lesson_2_7.DirectionalList;

public class OneDirectionalList implements DirectionalList {

    private Node first;

    public class Node {
        private String val;
        private Node nextLink;

        public Node(String val, Node nextLink) {
            this.val = val;
            this.nextLink = nextLink;
        }

        public String getVal() {
            return val;
        }

        public Node getNextLink() {
            return nextLink;
        }

        public void setNextLink(Node nextLink) {
            this.nextLink = nextLink;
        }
    }

    @Override
    public Node getFirst() {
        return first;
    }


    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(val, null);

        } else {

            add(val, first);

        }
    }

    private void add(String val, Node current) {
        if (current.getNextLink() == null) {
            current.setNextLink(new Node(val, null));
        } else {
            add(val, current.getNextLink());
        }
    }


    @Override
    public boolean remove(String val) {
        if (first.getVal().equals(val)) {
            if (first.getNextLink() == null) {
                first = null;
            } else {
                /**
                 * Будьте внимательные происходит замена ссылки
                 * first уже не будет прежним
                 */
                first = first.getNextLink();
            }
            return true;
        }

        Node current = this.first.getNextLink();
        Node prev = this.first;

        while (current != null) {
            if (current.getVal().equals(val)) {
                prev.setNextLink(current.getNextLink());
                return true;
            } else {
                prev = current;
                current = current.getNextLink();
            }
        }

        return false;
    }


    /**
     * Вариант с рекурсией
     */
//    @Override
//    public boolean remove(String val) {
//        if (first.getVal().equals(val)) {
//            if (first.getNext() == null) {
//                first = null;
//            } else {
//                first = first.getNext();
//            }
//            return true;
//        }
//        return remove(val, first, first.getNext());
//    }
//
//    private boolean remove(String val, Node prev, Node current) {
//        if (current == null) {
//            return false;
//        }
//
//        if (current.getVal().equals(val)) {
//            prev.setNext(current.getNext());
//            return true;
//        }
//
//        return remove(val, current, current.getNext());
//    }
    @Override
    public int size() {
        if (first == null) {
            return 0;
        }

        int size = 1;

        Node current = this.first;
        while (current.getNextLink() != null) {
            size++;
            current = current.getNextLink();
        }
        return size;
    }


}


//main

//        OneDirectionalList List = new OneDirectionalList();
//
//        List.add("val1");
//        List.add("val2");
//        List.add("val3");
//        List.add("val4");
//
//
//        OneDirectionalList.Node current = (OneDirectionalList.Node) List.getFirst();
//
//        System.out.println(current.getVal());
//        System.out.println(current.getNextLink().getVal());
//        System.out.println(current.getNextLink().getNextLink().getVal());
//        System.out.println(current.getNextLink().getNextLink().getNextLink().getVal());
//        System.out.println(current.getNextLink().getNextLink().getNextLink().getNextLink());
//
//        System.out.println("Size: " + List.size());
//
//        System.out.println("Removed? - " + directionalList.remove("val6"));
//        System.out.println("Removed? - " + directionalList.remove("val3"));
//
//        System.out.println(current.getVal());
//        System.out.println(current.getNextLink().getVal());
//        System.out.println(current.getNextLink().getNextLink().getVal());

