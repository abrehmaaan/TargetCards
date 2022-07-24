public class LinkedStack implements Stack {
	
	private class Node {		//Node class that holds data for current stack level and link to next element
        int num;				//data-> size of disk
        Node link;				//link to other node
    }
    Node top;					//top of the stack
	int size;					//size of stack
    LinkedStack()				//constructor
    {
        this.top = null;
        size=0;
    }
    public void push(int o)			//pushing data into stack
    {
        Node temp = new Node();			//creating new data
        temp.num = o;					//storing data
        temp.link = top;				//creating link
        top = temp;						//updating top and size
        size++;
    }
    public boolean isEmpty()
    {
        return top == null;				//returning true if top is null
    }
    public int peek()					//fucntion for peeking data at top of stack
    {
        if (!isEmpty()) {				//if stack is not empty
            return top.num;				//returning data
        }
        else {							//else displaying empty message
            System.out.println("Stack is empty");
            return -1;
        }
    }
    public int pop()					//popping element from stack (disk from tower)
    {
        if (top == null) {				//if stack is empty returning null
            System.out.print("\nStack Underflow");
            return -1;
        }	
        //else returning data at top pointer and updating top pointer
        int topnum = top.num;
        top = (top).link;
        size--;
        return topnum;
    }	
	public int size() {
		return this.size;			//function for getting current size of stack
	}
	public void display()			//fucntion for displaying stack
    {
        {
            Node temp = top;		//setting a temporary node equal to top for iteration
            while (temp != null) {			//while stack is not reached at end traversing data
            	if(temp.num>0) {
            		for(int i=0;i<temp.num;i++) {
            			System.out.print("-");			//displaying - for each number, (disk of hanoi tower)
            		}
            		System.out.println();
            	}
            	else
            		System.out.println(" ");			//if tower has no disk, displaying empty space
                temp = temp.link;
            }
        }
    }
}