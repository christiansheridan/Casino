package io.zipcoder.casino.CardGame.Solitaire;

import io.zipcoder.casino.CardGame.Card;

import java.util.Stack;

public class Tableau {

    //consider making an undo method

    public Stack<Card> stack;
    public static Stack<Card> tempStack;

    public Tableau(){
        this.stack = new Stack<>();
        this.tempStack = new Stack<>();
    }

    public Integer size() { return stack.size(); }

    public void add(Card c){
        stack.push(c);
    }

    //need to preface with a find stack method. maybe at higher level that feeds into this.stack
    // - so that player doesn't have to select the stack, he can just type in card to place onto.

    //c = the top card of the subStack you want to pull - ex. 6D, 5C, 4H, 3S, 2D, AS; if pulling 4H and down, c = 4H.
    public Stack<Card> pull(Card c){
        if(stack.contains(c)){
            while(!stack.peek().equals(c))  tempStack.push(stack.pop());
            tempStack.push(stack.pop());
            }
        return tempStack;
        }

    //does not need parameter. with a stack representing each column, will simply call 'stack'.place() to drop the tempStack on top of it.
    public void place(){
        if (this.canReceive(tempStack.peek())){
//            for(Card c : tempStack){
//                tempStack.pop();
//                stack.push(c);
//            }
            while(tempStack.iterator().hasNext()){
                stack.push(tempStack.pop());
            }
//           tempStack.forEach(e -> stack.push(tempStack.pop()));
        }
    }

    //checks whether 'top' card of stack is opposite color and 1 above passed card
    private boolean canReceive(Card c) {
        if ((this.stack.peek().getFace().getValue() - 1) == c.getFace().getValue()
                && (this.stack.peek().isBlack() != c.isBlack())) {
            return true;
        } else {
            System.out.println("Can't match " + stack.peek().toString() + " and " + c.toString());
            return false;
        }
    }
}
