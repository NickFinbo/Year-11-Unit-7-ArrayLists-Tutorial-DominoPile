public class Domino {
    int top;
    int bottom;

    public Domino() {
        top = 0;
        bottom = 0;
    }

    public Domino(int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    @Override
    public String toString() {
        return "Domino{" +
                "top=" + top +
                ", bottom=" + bottom +
                '}';
    }

    public void flip() {
        int store = bottom;
        bottom = top;
        top = store;
    }

    public void settle() {
        if(bottom < top) {
            flip();
        }
    }

    public int compareTo(Domino other){
        settle();
        other.settle();

        if(getTop()<other.getTop()){
            return -1;
        }
        if(getTop()>other.getTop()){
            return 1;
        }
        if(getTop() == other.getTop()){
            if(other.getBottom() > bottom) {
                return -1;
            } else if(other.getBottom() < bottom) {
                return 1;
            }
        }
        return 3;
    }

    public int compareToWeight(Domino other) {
        int thisWeight = getTop() + getBottom();
        int otherWeight = other.getTop() + other.getBottom();

        if(thisWeight < otherWeight) {
            return -1;
        } else if (thisWeight > otherWeight) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean canConnect(Domino other) {
        return (top == other.getTop() || bottom == other.getBottom() || top == other.getBottom() || bottom == other.getTop());
    }

}
