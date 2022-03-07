package chapter4;

import chapter4.section7.Fill;
import nz.sodium.Cell;
import pump.Delivery;
import pump.Fuel;

import java.util.Optional;

public class Preset {
    public final Cell<Delivery> delivery;
    public final Cell<Boolean> keypadActive;

    public enum speed {FAST, SLOW, STOPPED};

    public Preset(Cell<Integer> presetDollars, Fill fi, Cell<Optional<Fuel>> fuelFlowing, Cell<Boolean> fillActive){
        Cell<chapter4.section11.Preset.Speed> speed = presetDollars.lift(
                fi.price, fi.dollarsDelivered, fi.litersDelivered, ( presetDollars_, price, dollarsDelivered, litersDelivered)->{
                    if(presetDollars_==0)
                        return chapter4.section11.Preset.Speed.FAST;
                    else{
                        if(dollarsDelivered >= (double)presetDollars_)
                            return chapter4.section11.Preset.Speed.STOPPED;
                        double slowLiters = (double) presetDollars_ / price - 0.10;
                        if (litersDelivered>=slowLiters)
                            return chapter4.section11.Preset.Speed.SLOW;
                        else
                            return chapter4.section11.Preset.Speed.FAST;
                    }
                });
        delivery = fuelFlowing.lift(speed,
                (of, speed_) ->
                        speed_ == chapter4.section11.Preset.Speed.FAST ? (
                                of.equals(Optional.of(Fuel.ONE)) ? Delivery.FAST1 :
                                        of.equals(Optional.of(Fuel.TWO)) ? Delivery.FAST2 :
                                                of.equals(Optional.of(Fuel.THREE)) ? Delivery.FAST3 :
                                                        Delivery.OFF
                        ) :
                                speed_ == chapter4.section11.Preset.Speed.SLOW ? (
                                        of.equals(Optional.of(Fuel.ONE)) ? Delivery.SLOW1 :
                                                of.equals(Optional.of(Fuel.TWO)) ? Delivery.SLOW2 :
                                                        of.equals(Optional.of(Fuel.THREE)) ? Delivery.SLOW3 :
                                                                Delivery.OFF

                                ) :
                                        Delivery.OFF);
        keypadActive = fuelFlowing.lift(speed,
                (of, speed_) ->
                        !of.isPresent() || speed_ == chapter4.section11.Preset.Speed.FAST
        );
    }


}
