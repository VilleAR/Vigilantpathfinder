/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigilant.pathfinder;

/**
 *
 */
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DstTest {
    Dst dst;
    Dst dst2;
    @Before 
    public void setUp() {
        dst=new Dst(2);
        dst2=new Dst(3);
    }
    @Test
    public void minSize() { //testaa, hyväksyykö Dst koon oikein
        String tavoite = "Too small!!!";
        assertEquals(tavoite, dst.testMap());
        String tavoite2="t";
        assertEquals(tavoite2, dst2.testMap());
    }
}
