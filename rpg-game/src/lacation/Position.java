package lacation;

public class Position<T> {
    private Lacations last;
    private Lacations current;

    public Position() {
        this.current = null;
        this.last = null;
    }

    private boolean isEmpty(){
        return current == null;
    }

    public void start(T values){
        if(isEmpty()){
            Lacations<T> temp = new Lacations<>(values);
            current = temp;
        } else System.out.println("Уже запусчен");
    }

    public void goLeft(){
        if(current.left != null){
            last = current;
            current = current.left;
        }
    }

    public void goRights(){
        if(current.rights != null){
            last = current;
            current = current.rights;
        }
    }

    public void goUp(){
        if(current.up != null){
            last = current;
            current = current.up;
        }
    }

    public void goDown(){
        if(current.down != null){
            last = current;
            current = current.down;
        }
    }

    public void goLeft(T values){
        if(isEmpty()){
            start(values);
            return;
        }
        else {
            Lacations<T> temp = new Lacations<>(values);
            current.left = temp;
            current.left.rights = current;
            if(current.down != null){
                current.down.leftUp = current.left;
                current.left.rightsDown = current.down;
            }if(current.up != null){
                current.up.leftDown = current.left;
                current.left.rightsUp = current.up;
            }if(current.leftUp != null){
                current.left.up = current.leftUp;
                current.leftUp.down = current.left;
            }if(current.leftDown != null){
                current.left.down = current.leftDown;
                current.leftDown.up = current.left;
            }
            last = current;
            current = current.left;
        }
    }

    public void goRights(T values){
        if(isEmpty()){
            start(values);
            return;
        }else {
            Lacations<T> temp = new Lacations<>(values);
            current.rights = temp;
            current.rights.left = current;
            if(current.down != null){
                current.down.rightsUp = current.rights;
                current.rights.leftDown = current.down;
            }if(current.up != null){
                current.up.rightsDown = current.rights;
                current.rights.leftUp = current.up;
            }if(current.rightsUp != null){
                current.rights.up = current.rightsUp;
                current.rightsUp.down = current.rights;
            }if(current.rightsDown != null){
                current.rights.down = current.rightsDown;
                current.rightsDown.up = current.rights;
            }
            last = current;
            current = current.rights;
        }
    }

    public void goUp(T values){
        if(isEmpty()){
            start(values);
            return;
        }else {
            Lacations<T> temp = new Lacations<>(values);
            current.up = temp;
            current.up.down = current;
            if(current.left != null){
                current.up.leftDown = current.left;
                current.left.rightsUp = current.up;
            }if(current.rights != null){
                current.up.rightsDown = current.rights;
                current.rights.leftUp = current.up;
            }if(current.leftUp != null){
                current.up.left = current.leftUp;
                current.leftUp.rights = current.up;
            }if(current.rightsUp != null){
                current.up.rights = current.rightsUp;
                current.rightsUp.left = current.up;
            }
            last = current;
            current = current.up;
        }
    }

    public void goDown(T values){
        if(isEmpty()){
            start(values);
            return;
        }else {
            Lacations<T> temp = new Lacations<>(values);
            current.down = temp;
            current.down.up = current;
            if(current.left != null){
                current.left.rightsDown = current.down;
                current.down.leftUp = current.left;
            }if(current.rights != null){
                current.rights.leftDown = current.down;
                current.down.rightsUp = current.rights;
            }if(current.leftDown != null){
                current.leftDown.rights = current.down;
                current.down.left = current.leftDown;
            }if(current.rightsDown != null){
                current.rightsDown.left = current.down;
                current.down.rights = current.rightsDown;
            }
            last = current;
            current = current.down;
        }
    }

//    public void printLFirst(){
//        Lacations temp = first;
//        while (temp != null){
//            temp.printValues();
//            temp = temp.next;
//        }
//    }
//    public void printLast(){
//        Lacations temp = last;
//        while (temp != null){
//            temp.printValues();
//            temp = temp.previus;
//        }
//    }
}
