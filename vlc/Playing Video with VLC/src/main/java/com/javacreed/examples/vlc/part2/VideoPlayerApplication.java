/*
 * #%L
 * Playing Video with VLC
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2012 - 2014 Java Creed
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.javacreed.examples.vlc.part2;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class VideoPlayerApplication extends JFrame implements View {

  private static final long serialVersionUID = 6755657684516321877L;

  private Presenter presenter;

  private EmbeddedMediaPlayerComponent mediaPlayerComponent;

  @Override
  public void destroy() {
    dispose();
  }

  @Override
  public EmbeddedMediaPlayer getMediaPlayer() {
    return mediaPlayerComponent.getMediaPlayer();
  }

  private Presenter getPresenter() {
    if (presenter == null) {
      throw new IllegalStateException("Presenter is not set");
    }
    return presenter;
  }

  @Override
  public void init() {
    final Presenter presenter = getPresenter();

    setTitle("Playing Video with VLC (Part 2)");
    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    setSize(800, 600);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(final WindowEvent e) {
        presenter.onClose();
      }
    });

    initComponents();
  }

  private void initComponents() {
    final Presenter presenter = getPresenter();

    mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
    add(mediaPlayerComponent, BorderLayout.CENTER);

    final JPanel controlsPanel = new JPanel();
    add(controlsPanel, BorderLayout.SOUTH);

    controlsPanel.add(new JButton(presenter.getOpenAction()));
    controlsPanel.add(new JButton(presenter.getStopAction()));
  }

  @Override
  public void setPresenter(final Presenter presenter) {
    this.presenter = Objects.requireNonNull(presenter);
  }

  @Override
  public void showError(final String title, final String message) {
    JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void showMessage(final String title, final String message) {
    JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
  }

  @Override
  public File showOpenFileDialog(final File directory, final File selectedFile) {
    final JFileChooser fileChooser = new JFileChooser(directory);
    fileChooser.setAcceptAllFileFilterUsed(true);
    if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
      return fileChooser.getSelectedFile();
    }
    return null;
  }

  @Override
  public void showView(final boolean show) {
    setVisible(show);
  }

  @Override
  public void showWarning(final String title, final String message) {
    JOptionPane.showMessageDialog(this, message, title, JOptionPane.WARNING_MESSAGE);
  }

}
