package com.droid.map;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class DroidMap233Activity extends MapActivity {
    /** Called when the activity is first created. */
    @Override
    
    /* Necessary Method for MapActivitys */
    protected boolean isRouteDisplayed() {
    	return false;
    	}
    /*//////////////////////////////////////*/
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /* Link Layout and Built in Zoom Integrated */	
        MapView mapView = (MapView)findViewById(R.id.mapview);
        /*Set Center Focus*/
        MapController mapViewController = mapView.getController();
        mapViewController.setCenter(new GeoPoint((int)(13.549095*1e6),(int)(101.615777*1e6)));
        mapView.setBuiltInZoomControls(true);
        mapView.setSatellite(true);
        /*-------------------------------------------*/
        
        /* Get overlays item here */
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.home);
        ItemOverlay itemoverlay = new ItemOverlay(drawable,this);
        
        /*Show points*/
        /*University*/
        /*
        GeoPoint point = new GeoPoint((int)( 13.67613*1e6), (int)(101.070579*1e6));
        OverlayItem overlayitem = new OverlayItem(point, "Sawasdee!", "Rajabhat Rajanagarindra U’");
        */
        /*Home*/
        GeoPoint homePoint = new GeoPoint((int)(13.541986*1e6), (int)(100.971651*1e6));
        OverlayItem myHome = new OverlayItem(homePoint, "Hi", "Here Where I live!");
        
        
        /*adding overlay item*/
        /*University*/
        //itemoverlay.addOverlay(overlayitem);
       // mapOverlays.add(itemoverlay);
        /*Home*/
        itemoverlay.addOverlay(myHome);
        mapOverlays.add(itemoverlay);
        
    }
}