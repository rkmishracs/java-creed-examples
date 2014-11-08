package com.javacreed.examples.vlc.part2;

import javax.swing.Action;

public interface Presenter {

  void onClose();

  Action getOpenAction();

  Action getStopAction();

}
