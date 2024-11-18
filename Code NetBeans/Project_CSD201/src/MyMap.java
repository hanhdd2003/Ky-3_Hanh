/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hanh
 */
public class MyMap {

    public void generateMap2() {
        // generate vertice
        Vertex w1 = new Vertex("w1");
        Vertex w2 = new Vertex("w2");
        Vertex w3 = new Vertex("w3");
        Vertex w4 = new Vertex("w4");
        Vertex w5 = new Vertex("w5");
        Vertex w6 = new Vertex("w6");
        Vertex w7 = new Vertex("w7");
        Vertex w8 = new Vertex("w8");
        Vertex w9 = new Vertex("w9");
        Vertex w10 = new Vertex("w10");
        Vertex w11 = new Vertex("w11");
        Vertex w12 = new Vertex("w12");
        Vertex w13 = new Vertex("w13");
        Vertex w14 = new Vertex("w14");
        Vertex h1 = new Vertex("h1");
        Vertex h2 = new Vertex("h2");
        Vertex h3 = new Vertex("h3");
        Vertex h4 = new Vertex("h4");
        Vertex h5 = new Vertex("h5");
        Vertex h6 = new Vertex("h6");
        Vertex h7 = new Vertex("h7");
        Vertex h8 = new Vertex("h8");
        Vertex h9 = new Vertex("h9");
        Vertex h10 = new Vertex("h10");
        Vertex h11 = new Vertex("h11");
        Vertex h12 = new Vertex("h12");
        Vertex h13 = new Vertex("h13");
        Vertex h14 = new Vertex("h14");
        Vertex h15 = new Vertex("h15");
        Vertex h16 = new Vertex("h16");
        Vertex h17 = new Vertex("h17");
        Vertex h18 = new Vertex("h18");
        Vertex h19 = new Vertex("h19");
        Vertex h20 = new Vertex("h20");
        Vertex h21 = new Vertex("h21");
        Vertex h22 = new Vertex("h22");
        Vertex h23 = new Vertex("h23");
        Vertex a1 = new Vertex("a1");
        Vertex a2 = new Vertex("a2");
        Vertex a3 = new Vertex("a3");
        Vertex a4 = new Vertex("a4");
        Vertex a5 = new Vertex("a5");
        Vertex a6 = new Vertex("a6");
        Vertex a7 = new Vertex("a7");
        Vertex a8 = new Vertex("a8");
        Vertex a9 = new Vertex("a9");
        Vertex a10 = new Vertex("a10");
        Vertex a11 = new Vertex("a11");
        Vertex a12 = new Vertex("a12");
        Vertex a13 = new Vertex("a13");
        Vertex a14 = new Vertex("a14");
        Vertex a15 = new Vertex("a15");
        Vertex a16 = new Vertex("a16");
        Vertex a17 = new Vertex("a17");
        Vertex a18 = new Vertex("a18");
        Vertex b1 = new Vertex("b1");
        Vertex b2 = new Vertex("b2");
        Vertex b3 = new Vertex("b3");
        Vertex b4 = new Vertex("b4");
        Vertex b5 = new Vertex("b5");
        Vertex b6 = new Vertex("b6");
        Vertex g1 = new Vertex("g1");
        Vertex g2 = new Vertex("g2");
        Vertex g3 = new Vertex("g3");
        Vertex g4 = new Vertex("g4");
        Vertex lake = new Vertex("Lake");
        Vertex zoo = new Vertex("Zoo");
        Vertex restaurant = new Vertex("Restaurant");
        Vertex market = new Vertex("Market");
        Vertex cafe = new Vertex("cafe");
        Vertex school = new Vertex("School");
        Vertex policeOffice = new Vertex("Police Officie");
        Vertex cemetery = new Vertex("Cemetery");
        Vertex hospital = new Vertex("Hospital");
        Vertex stalls = new Vertex("Stalls");
        // add neighbor
        w1.addNeighbor(h1);w1.addNeighbor(b1);
        w2.addNeighbor(b1);w2.addNeighbor(a1);w2.addNeighbor(g1);w2.addNeighbor(h9);
        w3.addNeighbor(g1);w3.addNeighbor(h2);w3.addNeighbor(w4);
        w4.addNeighbor(w3);w4.addNeighbor(b2);w4.addNeighbor(h10);
        w5.addNeighbor(h3);w5.addNeighbor(restaurant);w5.addNeighbor(a7);
        w6.addNeighbor(restaurant);w6.addNeighbor(h4);w6.addNeighbor(g2);
        w7.addNeighbor(g2);w7.addNeighbor(a4);w7.addNeighbor(h8);
        w8.addNeighbor(school);w8.addNeighbor(b4);w8.addNeighbor(hospital);
        w9.addNeighbor(hospital);w9.addNeighbor(zoo);w9.addNeighbor(h22);
        w10.addNeighbor(a14);w10.addNeighbor(g3);w10.addNeighbor(w11);
        w11.addNeighbor(w10);w11.addNeighbor(stalls);w11.addNeighbor(h17);
        w12.addNeighbor(b6);w12.addNeighbor(g4);w12.addNeighbor(h15);w12.addNeighbor(b6);
        w13.addNeighbor(g4);w13.addNeighbor(a13);w13.addNeighbor(w14);
        w14.addNeighbor(w13);w14.addNeighbor(h14);
        
        h1.addNeighbor(w1);h1.addNeighbor(a1);
        h2.addNeighbor(w3);
        h3.addNeighbor(b2);h3.addNeighbor(w5);
        h4.addNeighbor(w6);h4.addNeighbor(a2);
        h5.addNeighbor(a3); h5.addNeighbor(a4);
        h6.addNeighbor(a5);
        h7.addNeighbor(a4); h7.addNeighbor(a5);
        h8.addNeighbor(w7); h8.addNeighbor(a8); h8.addNeighbor(b3);
        h9.addNeighbor(w2); h9.addNeighbor(a9);
        h10.addNeighbor(w4); h10.addNeighbor(a6);
        h11.addNeighbor(a7); h11.addNeighbor(a12);
        h12.addNeighbor(a10); h12.addNeighbor(a11);
        h13.addNeighbor(a13);
        h14.addNeighbor(w4); h14.addNeighbor(a15);
        h15.addNeighbor(w12);  h15.addNeighbor(a15);
        h16.addNeighbor(a15); h16.addNeighbor(a16);
        h17.addNeighbor(w11); h17.addNeighbor(h18);
        h18.addNeighbor(a16); h18.addNeighbor(h17); h18.addNeighbor(a17);
        h19.addNeighbor(h20); h19.addNeighbor(a17);
        h20.addNeighbor(h19);
        h21.addNeighbor(lake);
        h22.addNeighbor(w9); h22.addNeighbor(h23);
        h23.addNeighbor(h22);
        
        a1.addNeighbor(h1);a1.addNeighbor(w2);
        a2.addNeighbor(h4);a2.addNeighbor(a3);
        a3.addNeighbor(a2);a3.addNeighbor(h5);
        a4.addNeighbor(h5);a4.addNeighbor(h7);a4.addNeighbor(w7);
        a5.addNeighbor(h6);a5.addNeighbor(h7);
        a6.addNeighbor(h10);a6.addNeighbor(a10);a6.addNeighbor(a7);a6.addNeighbor(a11);
        a7.addNeighbor(w5);a7.addNeighbor(h11); a7.addNeighbor(a6);
        a8.addNeighbor(market);a8.addNeighbor(a12);a8.addNeighbor(h8);a8.addNeighbor(cafe);
        a9.addNeighbor(h9);a9.addNeighbor(a10);a9.addNeighbor(a13);
        a10.addNeighbor(a9); a10.addNeighbor(a6);a10.addNeighbor(h12);
        a11.addNeighbor(h12); a11.addNeighbor(a6);
        a12.addNeighbor(h11);a12.addNeighbor(a8);a12.addNeighbor(a14);
        a13.addNeighbor(h13); a13.addNeighbor(w13);
        a14.addNeighbor(a12); a14.addNeighbor(cafe);a14.addNeighbor(w10);
        a15.addNeighbor(h14); a15.addNeighbor(h15); a15.addNeighbor(h16);
        a16.addNeighbor(h16); a16.addNeighbor(h18);
        a17.addNeighbor(h18); a17.addNeighbor(h19); a17.addNeighbor(a18);
        a18.addNeighbor(a17); a18.addNeighbor(lake);

        b1.addNeighbor(w1); b1.addNeighbor(w2);
        b2.addNeighbor(w4); b2.addNeighbor(h3);
        b3.addNeighbor(h8); b3.addNeighbor(school);
        b4.addNeighbor(policeOffice); b4.addNeighbor(w8);
        b5.addNeighbor(zoo); b5.addNeighbor(g3);
        b6.addNeighbor(stalls); b6.addNeighbor(w12);
        
        g1.addNeighbor(w2); g1.addNeighbor(w3);
        g2.addNeighbor(w6); g2.addNeighbor(w7);
        g3.addNeighbor(b5); g3.addNeighbor(w10);
        g4.addNeighbor(w12); g4.addNeighbor(w13);
        restaurant.addNeighbor(w5); restaurant.addNeighbor(w6);
        market.addNeighbor(a8);
        cafe.addNeighbor(a8); cafe.addNeighbor(a14);
        school.addNeighbor(b3); school.addNeighbor(w8);
        policeOffice.addNeighbor(cemetery); policeOffice.addNeighbor(b4);
        cemetery.addNeighbor(policeOffice);
        hospital.addNeighbor(w8); hospital.addNeighbor(w9);
        zoo.addNeighbor(w9); zoo.addNeighbor(b5);
        lake.addNeighbor(a18); lake.addNeighbor(h21);
        stalls.addNeighbor(b6); stalls.addNeighbor(w11);
        
        //add edge
        Edge w1_h1 = new Edge(w1, h1, 0.7);
        Edge h1_a1 = new Edge(h1, a1, 0.7);
        Edge w1_b1 = new Edge(w1, b1, 0.55);
        Edge b1_w2 = new Edge(b1, w2, 0.45);
        Edge a1_w2 = new Edge(a1, w2, 0.6);
        Edge w2_g1 = new Edge(w2, g1, 0.35);
        Edge g1_w3 = new Edge(g1, w3, 0.25);
        Edge w3_h2 = new Edge(w3, h2, 0.6);
        Edge w3_w4 = new Edge(w3, w4, 0.5);
        Edge w4_h10 = new Edge(w4, h10, 0.45);
        Edge w2_h9 = new Edge(w2, h9, 0.55);
        Edge h9_a9 = new Edge(h9, a9, 1.05);
        Edge a9_a13 = new Edge(a9, a13, 1.05);
        Edge a13_h13 = new Edge(a13, h13, 0.3);
        Edge a13_w13 = new Edge(a13, w13, 0.55);
        Edge a9_a10 = new Edge(a9, a10, 0.25);
        Edge a10_h12 = new Edge(a10, h12, 0.25);
        Edge h12_a11 = new Edge(h12, a11, 0.55);
        Edge a10_a6 = new Edge(a10, a6, 1.15);
        Edge a11_a6 = new Edge(a11, a6, 0.75);
        Edge a6_a7 = new Edge(a6, a7, 1.2);
        Edge w4_b2 = new Edge(w4, b2, 0.5);
        Edge b2_h3 = new Edge(b2, h3, 0.45);
        Edge h3_w5 = new Edge(h5, w5, 0.2);
        Edge h3_restaurant = new Edge(h3, restaurant, 0.55);
        Edge restaurant_w6 = new Edge(restaurant, w6, 0.7);
        Edge w6_h4 = new Edge(w6, h4, 0.45);
        Edge h4_a2 = new Edge(h4, a2, 0.45);
        Edge a2_a3 = new Edge(a2, a3, 1.2);
        Edge a3_h5 = new Edge(a3, h5, 0.25);
        Edge h5_a4 = new Edge(h5, a4, 0.55);
        Edge a4_h7 = new Edge(a4, h7, 0.8);
        Edge h7_a5 = new Edge(h7, a5, 0.45);
        Edge a5_h6 = new Edge(a5, h6, 0.6);
        Edge w6_g2 = new Edge(w6, g2, 0.7);
        Edge g2_w7 = new Edge(g2, w7, 0.8);
        Edge w7_a4 = new Edge(w7, a4, 0.65);
        Edge w7_h8 = new Edge(w7, h8, 0.2);
        Edge w5_a7 = new Edge(w5, a7, 0.9);
        Edge a7_h11 = new Edge(a7, h11, 0.4);
        Edge h11_a12 = new Edge(h11, a12, 0.45);
        Edge a12_a8 = new Edge(a12, a8, 1.3);
        Edge a8_market = new Edge(a8, market, 0.5);
        Edge a8_h8 = new Edge(a8, h8, 1.35);
        Edge a8_cafe = new Edge(a8, cafe, 0.75);
        Edge a12_a14 = new Edge(a12, a14, 0.65);
        Edge a14_cafe = new Edge(a14, cafe, 1.3);
        Edge a14_w10 = new Edge(a14, w10, 0.7);
        Edge h8_b3 = new Edge(h8, b3, 0.8);
        Edge b3_scholl = new Edge(b3, school, 0.5);
        Edge school_w8 = new Edge(school, w8, 1.3);
        Edge w8_b4 = new Edge(w8, b4, 0.2);
        Edge b4_police = new Edge(b4, policeOffice, 0.55);
        Edge police_cemetery = new Edge(policeOffice, cemetery, 0.5);
        Edge w8_hospital = new Edge(w8, hospital, 0.3);
        Edge hospital_w9 = new Edge(hospital, w9, 0.55);
        Edge w9_zoo = new Edge(w9, zoo, 0.6);
        Edge zoo_b5 = new Edge(zoo, b5, 0.6);
        Edge w9_h22 = new Edge(w9, h22, 1.2);
        Edge h22_h23 = new Edge(h22, h23, 1.3);
        Edge b5_g3 = new Edge(b5, g3, 1.2);
        Edge g3_w10 = new Edge(g3, w10, 0.8);
        Edge w10_w11 = new Edge(w10, w11, 0.7);
        Edge w11_stalls = new Edge(w11, stalls, 0.25);
        Edge stalls_b6 = new Edge(stalls, b6, 0.5);
        Edge b6_w12 = new Edge(b6, w12, 0.45);
        Edge w12_g4 = new Edge(w12, g4, 0.5);
        Edge w12_h15 = new Edge(w12, h15, 0.45);
        Edge h15_a15 = new Edge(h15, a15, 0.55);
        Edge w11_h17 = new Edge(w11, h17, 0.55);
        Edge h17_h18 = new Edge(h17, h18, 0.9);
        Edge g4_w13 = new Edge(g4, w13, 0.7);
        Edge w13_w14 = new Edge(w13, w14, 0.25);
        Edge w14_h14 = new Edge(w14, h14, 0.55);
        Edge h14_a15 = new Edge(h14, a15, 0.9);
        Edge a15_h16 = new Edge(a15, h16, 0.45);
        Edge h16_a16 = new Edge(h16, a16, 0.5);
        Edge a16_h18 = new Edge(a16, h18, 0.6);
        Edge h18_a17 = new Edge(h18, a17, 1.0);
        Edge a17_h19 = new Edge(a17, h19, 0.5);
        Edge h19_h20 = new Edge(h19, h20, 0.7);
        Edge a17_a18 = new Edge(a17, a18, 0.5);
        Edge a18_lake = new Edge(a18, lake, 0.5);
        Edge lake_h21 = new Edge(lake, h21, 0.75);
        
        
    }
}
