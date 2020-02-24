package com.sammy.etweaks.fragments.other;

import com.sammy.etweaks.R;
import com.sammy.etweaks.fragments.recyclerview.RecyclerViewFragment;
import com.sammy.etweaks.utils.Utils;
import com.sammy.etweaks.views.recyclerview.DescriptionView;
import com.sammy.etweaks.views.recyclerview.ImageView;
import com.sammy.etweaks.views.recyclerview.RecyclerViewItem;
import com.sammy.etweaks.views.recyclerview.TitleView;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * Created by Morogoku on 05/12/2017.
 */

public class DonationFragment extends RecyclerViewFragment {


    @Override
    protected boolean showViewPager() {
        return false;
    }

    @Override
    protected void addItems(List<RecyclerViewItem> items) {

        TitleView title = new TitleView();
        title.setText(getString(R.string.donation_title));

        items.add(title);


        DescriptionView desc = new DescriptionView();
        desc.setDrawable(getResources().getDrawable(R.drawable.logo));
        desc.setSummary(getString(R.string.donation_summary));
        desc.setOnItemClickListener(item
                -> Utils.launchUrl("https://www.paypal.me/morogoku", Objects.requireNonNull(getActivity())));

        items.add(desc);


        String leng = Locale.getDefault().getLanguage();

        ImageView img = new ImageView();
        if(leng.contains("es")){
            img.setDrawable(getResources().getDrawable(R.drawable.ic_donar_paypal));
        }else {
            img.setDrawable(getResources().getDrawable(R.drawable.ic_donate_paypal));
        }
        img.setOnItemClickListener(item
                -> Utils.launchUrl("https://www.paypal.me/morogoku", Objects.requireNonNull(getActivity())));

        items.add(img);

    }
}
