package ast;

import compiler.*;

/*
 Espresso Compiler - https://github.com/neevsamar/espresso.git
 
 Alireza Samar (A147053)
 Sepideh Sattar (A138894)
 */

public abstract class Node
{
    //the line and column number of the node's position in the source code
    protected int lineNumber, colNumber;

    /**
     * Construct a Node that was parsed at the given position in the source file
     * @param lineNumber the node's source's line number
     * @param colNumber the node's source's column number (the first char in the node's source)
     */
    protected Node(int lineNumber, int colNumber)
    {
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }

    /**
     * accept a visitor of the tree (see Visitor pattern, Gamma et al)
     * @param v the visitor to accept
     * @return some result of processing the node
     */
    public abstract Object accept(Visitor v);

    /**
     * returns the node's line number
     * @return the node's line number
     */
    public int getLineNumber()
    {
        return lineNumber;
    }

    /**
     * returns the node's column number
     * @return the node's column number
     */
    public int getColumnNumber()
    {
        return colNumber;
    }

    /**
     * returns the static type of the node, overridden by the sub-classes
     * @return "void" unless overridden by a sub-class
     */
    public String getType()
    {
        return "void";
    }
}