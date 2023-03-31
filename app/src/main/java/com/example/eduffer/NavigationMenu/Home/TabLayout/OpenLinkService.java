package com.example.eduffer.NavigationMenu.Home.TabLayout;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class OpenLinkService extends Service {

    private String url , link;
    private Intent i;

    public int onStartCommand(Intent intent , int flags, int startId) {
       if(intent != null){
            link = intent.getStringExtra("link");
            openlink(link);
        }
       else{
            Toast.makeText(getApplicationContext() , "ERROR" , Toast.LENGTH_SHORT).show();
        }

        stopSelf();
        return super.onStartCommand(intent , flags , startId);
            }

    public void openlink(String link) {
        switch (link) {
            case "adobe":
                url = "https://www.adobe.com/in/creativecloud/buy/students.html";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "coursera":
                url = "https://www.coursera.org/for-university-and-college-students?utm_medium=coursera&utm_source=c4cwebsite&utm_campaign=freecourseraforstudents";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "evernote" :
                url = "https://evernote.com/students";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "github" :
                url = "https://education.github.com/pack";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "impact" :
                url = "https://impactsoundworks.com/academic/";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "microsoft" :
                url = "https://docs.microsoft.com/en-us/learn/certifications/student-discounts";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "nytimes" :
                url = "https://www.nytimes.com/subscription";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "testbook" :
                url = "https://testbook.com/pass";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "udemy" :
                url = "https://www.udemy.com/";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "wix" :
                url = "https://www.wix.com/students";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "amazonprime":
                url = "https://www.amazon.in/b?ie=UTF8&node=15307611031&linkCode=sl2&tag=indg-21&linkId=56cfe97119c8571644b45dd30a1399d8&language=en_IN&ref_=as_li_ss_tl";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "spotify":
                url = "https://www.spotify.com/in-en/student/";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "ableton":
                url = "https://www.ableton.com/en/shop/education/";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "acer":
                url = "https://store.acer.com/en-in/special-offers/student-purchase-program";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "apple" :
                url = "https://www.apple.com/in/shop/education-pricing";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "hp" :
                url = "https://www.hp.com/in-en/shop/students/about-the-program";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "lenovo" :
                url = "https://lenovo.studentbeans.com/";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "gmicrosoft" :
                url = "https://www.microsoft.com/en-gd/store/b/student";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "oneplus" :
                url = "https://www.oneplus.in/education";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "realme" :
                url = "https://www.realme.com/eu/student-discount";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "samsung" :
                url = "https://www.samsung.com/us/shop/offer-program/education/";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "expedia":
                url = "https://www.expedia.com/student-travel-discounts";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "hostelworld":
                url = "https://www.hostelworld.com/hostels/India";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "marriott" :
                url = "https://www.marriott.com/meeting-event-hotels/group-travel/student-travel.mi";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "crocs":
                url = "https://shopcrocs.in/student-s-offer.html";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "ericdress":
                url = "https://www.ericdress.com/studentdiscount.html";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "lakme" :
                url = "https://www.lakme-academy.com/enquiry-student-enquiry";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "nike" :
                url = "https://www.nike.com/in/help/a/student-discount-gs";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "only" :
                url = "https://www.only.in/students";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "airindia":
                url = "https://www.airindia.in/student-concession.htm";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "britishairways":
                url = "https://www.britishairways.com/en-in/offers/flights/india-student-offer";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "emirates":
                url = "https://www.emirates.com/english/special-offers/student-special-fares/";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "easemytrip":
                url = "https://www.easemytrip.com/offers/students.html?CouponCode=EMTSTUDENT";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "gofirst":
                url = "https://www.flygofirst.com/offers-and-promotions/student-offer/";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "indigo":
                url = "https://www.goindigo.in/add-on-services/student-discount.html";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "isic":
                url = "https://isic.co.in/discounts/india/?dmLimit=10&dmSeed=1752&dmDisplay=images&dmText=Travel&dmCategoryId=449";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "lufthansa":
                url = "https://www.lufthansa.com/in/en/student-journey-from-india?utm_source=lh&utm_medium=teaser&utm_campaign=genfly_in_en";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "spicejet":
                url = "https://corporate.spicejet.com/studentdiscountlanding.aspx";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "surffares":
                url = "https://www.surffares.com/student-discount";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "virginatlantic":
                url = "https://www.virginatlantic.com/in/en/flight-deals/student-offer.html";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "yatra":
                url = "https://www.yatra.com/offer/details/international-airlines-emirates-student-offer";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "imagicaa":
                url = "https://www.imagicaaworld.com/offers/college-deal/";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "wonderla":
                url = "https://www.wonderla.com/offers/20-off-for-college-students.html";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
            case "worldsofwonder":
                url = "https://www.grabon.in/worldsofwonder-coupons/";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
