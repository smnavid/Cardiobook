package com.example.cardiobook;

import java.util.ArrayList;

public class MeasurementList {
    /**
     * Created by joshua2 on 9/29/15.
     */
// want to make observable
    public class MeasureList implements MyObservable, MyObserver {
        private Measurement measurement;
        private ArrayList<Measurement> measurements = new ArrayList<Measurement>();

        public void add(Measurement measurement) {

            measurements.add(measurement);
            measurement.addObserver(this);
            notifyAllObservers();
        }

        public Measurement get(int i) {
            return measurements.get(i);
        }

        public int count() {
            return measurements.size();
        }

        private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

        public void addObserver(MyObserver observer) {
            observers.add(observer);
        }

        private void notifyAllObservers() {
            for (MyObserver observer : observers) {
                observer.myNotify(this);
            }
        }

        public void myNotify(MyObservable observable) {
            notifyAllObservers();
        }

    }
}
