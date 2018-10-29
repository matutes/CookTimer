package com.eno.nael.cooktimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TipsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        ArrayList<String> tips =new ArrayList<String>();
        tips.add("\n1.  \"Be sure to reduce the salt\" can really save a recipe—and reduce its sodium content! —Julie Fagan, of Peanut Butter Fingers (pbfingers.com)\n");
        tips.add("\n2. Always crack an egg on a flat surface, never the edge of a bowl. Otherwise you'll risk shell shards and possible contamination of your " +
                "food. —Aida Mollenkamp, of Pairs Well with Food (aidamollenkamp.com)\n");
        tips.add("\n3. Don't throw out those last drips of jam in the jar; shake up a fruity vinaigrette instead. Add equal parts oil and vinegar to the jar," +
                " give it a good shake, and season with salt and pepper to taste. —Marisa McClellan, of Food in Jars (foodinjars.com)\n" +
                " ");
        tips.add("\n4. Cooking doesn't have to be entirely from scratch every single meal. Making easy homemade sauce for store-bought pasta still counts! —Kate Selner, of Kate in the Kitchen (kateinthekitchen.com)\n");
        tips.add("\n5. Soak bitter greens, like arugula or kale, in a bowl of ice water in the fridge for about an hour to cut their bitterness. Run the leaves through your salad spinner several times with a paper towel to get them nice and dry and crisp. —Dina Avila, of Leek Soup (leeksoupblog.com)\n");
        tips.add("\n6. When grilling flank or skirt steak, marinate it for 10 minutes after cooking instead of before. It adds amazing, full flavor in a tenth of the time. — Clay Dunn, of The Bitten Word (thebittenword.com)\n");
        tips.add("\n7. When a savory dish needs a little oomph, try a squeeze of lemon instead of salt. A hit of citrus can make the whole recipe come to life. — Erin Scott, of Yummy Supper (yummysupper.blogspot.com)\n" +
                " ");
        tips.add("\n8. Add hot sauce to your leftover pizza. It will taste great the next day, plus the chilies have antimicrobial properties that may help leftovers last longer. — Jada Cash DiCosola, of Better with Butter (betterwithbutter.com)\n");
        tips.add("\n9. Each time I make a batch of cookies, I bake one test cookie first. That way, if the oven is a little off that day, I can adjust the baking time accordingly and the rest of the cookies still come out perfectly. — Elana Amsterdam, of Elana's Pantry (elanaspantry.com)\n");
        tips.add("\n10. For a satisfyingly thick but dairy-free soup, add some cashew cream. It's delicious and easy to make: Soak one cup of raw cashews in water for six to eight hours, drain and rinse them, and blend with 3/4 cup water until smooth. — Angela Liddon, of Oh She Glows (ohsheglows.com)\n");
        tips.add("\n11. Pre-soak pasta and it will cook in about 60 seconds:\n "+
        "Sounds weird, but it works! Soak the pasta in water in a sealed bag for a couple hours or overnight. Then you can cook it super super fast in boiling water or just add it straight to a hot sauce in a pan and let it finish cooking there.\n");
        tips.add("\nCaramelize onions in half the time by adding a little baking soda:\n"+
        "");
        tips.add("\n12. Grate ginger with a microplane instead of mincing it.\n");
        tips.add("\n13. Grate ginger with a microplane instead of mincing it:\n"+"You can freeze the ginger first to make it firm and easy to grate.\n");
        tips.add("\n14 Microwave lemons and limes to get more juice out:\n"+"Zapping citrus for 15 or 20 seconds helps break down carbohydrates in the fruit and encourages maximum liquidity.\n");
        tips.add("\n15. Freeze meat to make it easier to slice for stir-fries and stews.\n");
        tips.add("\nmore TIPS in next update if you want to add some tips just contact me:\n"+"naeleno@gmail.com\n\n\n");

        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tips);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(arrayAdapter);

    }
}
