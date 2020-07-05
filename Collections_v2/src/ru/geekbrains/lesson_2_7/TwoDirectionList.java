package ru.geekbrains.lesson_2_7;

public class TwoDirectionList implements DirectionalList {

    private TwoDirectionNode current;


    public class TwoDirectionNode {

        private String val;
        private TwoDirectionNode nextLink;
        private TwoDirectionNode previousLink;

        public TwoDirectionNode(TwoDirectionNode previousLink, String val, TwoDirectionNode nextLink) {
            this.val = val;
            this.nextLink = nextLink;
            this.previousLink = previousLink;
        }

        public String getVal() {
            return val;
        }

        public TwoDirectionNode getNextLink() {
            return nextLink;
        }

        public TwoDirectionNode getPreviousLink() {
            return previousLink;
        }

        public void setPreviousLink(TwoDirectionNode previousLink) {
            this.previousLink = previousLink;
        }

        public void setNextLink(TwoDirectionNode nextLink) {
            this.nextLink = nextLink;
        }

    }


    @Override
    public void add(String val) {
        if (current == null) {
            current = new TwoDirectionList.TwoDirectionNode(null, val, null);
            return;
        }
        add(val, current);
    }

    private void add(String val, TwoDirectionNode current) {
        if (current.getNextLink() == null && current.getPreviousLink() == null) {
            current.setNextLink(new TwoDirectionNode(current.getPreviousLink(), val, null));
        } else {
            add(val, current.getNextLink());
        }
    }


    @Override
    public boolean remove(String val) {
        return false;
    }

    @Override
    public Object getFirst() {
        return current;
    }

    @Override
    public int size() {
        if (current == null) {
            return 0;
        }

        int size = 1;

        TwoDirectionNode currentVal = this.current;
        while (currentVal.getNextLink() != null) {
            size++;
            currentVal = currentVal.getNextLink();
        }
        return size;
    }
}
