/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;

/**
 *
 * @author Jairo Salazar
 * @param <N>
 * 
 */
public class NodeSLL<N extends Comparable<N>> {
    public final Comparable data;
    public NodeSLL next;
    public int index;
    public NodeSLL(Comparable data)
    {
        this.data = data;
        this.next = null;
    }

    public boolean hasNext()
    {
        return !(this.next==null);
    }
}
