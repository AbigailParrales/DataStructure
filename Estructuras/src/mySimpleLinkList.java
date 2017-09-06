/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jairo
 * @param  <N>
 */
public class mySimpleLinkList<N extends Comparable<N>>
{
    
    public NodeSLL head;
    boolean isEmpty;
    int size;
    
    public mySimpleLinkList()
    {
        this.head       = null;
        this.isEmpty    = true;
        this.size       = 0;
    }
    
    

    public boolean isEmpty()
    {
        return head==null;
    }
    
    public int size()
    {
        return size;
    }
    
    /*
    * @param <N>
    */
    public final NodeSLL get(int index)
    {
        NodeSLL iteradorInterno;
        iteradorInterno = this.head;
        while( iteradorInterno.hasNext() )
        {
            if( iteradorInterno.next.index == index )
            {
                NodeSLL nodeFound;
                nodeFound = iteradorInterno.next;
                iteradorInterno.next = iteradorInterno.next.next;
                return nodeFound;
            }
            else
            {
                iteradorInterno = iteradorInterno.next;
            }
        }
        return null;
    }
    
    public int add( Comparable data )
    {
        if( this.head == null )
        {
            this.head = new NodeSLL(data);
            this.size = this.size + 1; 
        }
        else
        {
            NodeSLL lastNode;
            lastNode = this.head;
            while( lastNode.hasNext() )
            {
                lastNode = lastNode.next;
            }
            lastNode.next   = new NodeSLL(data);
            this.size       = this.size + 1;
        }
        
        return 1;
    }
    
    public int remove( Comparable data )
    {
        if( this.head == null )
        {
            return 0; 
        }
        else
        {
            //Revisa el primer nodo
            if( data.compareTo(this.head.data) == 0 )
            {
                this.head = this.head.next;
                return 1;
            }
            else
            {
                //Revisa el resto de nodos
                NodeSLL backNode, actualNode;
                backNode    = null;
                actualNode  = this.head;
                while( actualNode != null )
                {
                    if( data.compareTo( actualNode.data ) == 0 )
                    {
                        if( backNode == null )
                        {
                            actualNode = actualNode.next;
                        }
                        else
                        {
                            backNode.next   = actualNode.next;
                        }
                        return 1;
                    }
                    else
                    {
                        backNode    = actualNode;
                        actualNode  = actualNode.next;
                    }
                }
            }                
        }
        return 0;
    }
}





