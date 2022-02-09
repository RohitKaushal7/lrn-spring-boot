package com.dev.rest.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dev.rest.models.Car;

import org.springframework.stereotype.Component;

@Component
public class ParkingService {
    // memory db
    List<Car> waitingList;
    Map<Integer,List<Car>> space;
    Map<Integer,Integer> dim;
    Map<Integer,Boolean> carExists;

    int N = 4;

    public ParkingService(Map<Integer, Integer> dim) {
        waitingList = new ArrayList<>();
        carExists = new HashMap<>();
        this.dim = dim;
        space = new HashMap<>();
        for(int i = 1; i <= N; ++i){
            space.put(i, new ArrayList<>());
        }
        
    }
    public ParkingService() {
        waitingList = new ArrayList<>();
        carExists = new HashMap<>();
        dim = new HashMap<>();
        for(int i = 1; i <= N; ++i){
            dim.put(i, (int)(1+ Math.random()*3));
        }
        space = new HashMap<>();
        for(int i = 1; i <= N; ++i){
            space.put(i, new ArrayList<>());
        }
    }

    // functions
    public void park(Car car){
        if(carExists.containsKey(car.getId()) || car.getSize() > N) return;
        int i = car.getSize();
        while(i <= N){
            if(space.get(i).size() < dim.get(i)){
                space.get(i).add(car);
                break;
            }
            i++;
        }
        if(i == N+1){
            waitingList.add(car);
        }
        carExists.put(car.getId(), true);
    }

    public void unpark(Car car){
        boolean removed = false;
        for (int i = 1; i <= N ; ++i){
            for(int j = 0; j < space.get(i).size(); ++j){
                if(space.get(i).get(j).getId() == car.getId()){
                    space.get(i).remove(j);
                    carExists.remove(car.getId());
                    removed = true;
                    break;
                }
            }
            if(removed) break;
        }

        // check waiting list
        for (int k = 0; k < waitingList.size(); ++k){
            Car c = waitingList.get(k);
            int i = c.getSize();
            while(i <= N){
                if(space.get(i).size() < dim.get(i)){
                    space.get(i).add(c);
                    waitingList.remove(k);
                    k--;
                    break;
                }
                i++;
            }
        }
    }

    // gettes and setters
    public List<Car> getWaitingList() {
        return waitingList;
    }
    public void setWaitingList(List<Car> waitingList) {
        this.waitingList = waitingList;
    }
    public Map<Integer, List<Car>> getSpace() {
        return space;
    }
    public void setSpace(Map<Integer, List<Car>> space) {
        this.space = space;
    }
    public Map<Integer, Integer> getDim() {
        return dim;
    }
    public void setDim(Map<Integer, Integer> dim) {
        this.dim = dim;
    }
    public int getN() {
        return N;
    }
    public void setN(int n) {
        N = n;
    }
}
