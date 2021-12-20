Team04
Jiaqi Huang jh106@iu.edu
luketang    luketang@iu.edu

In this lab7, we clone the lecture course code from GitHub. Then what we deleted what is
not need with main, such as the sever java files.
Then for the file of "clap.wav", I put 
"/Users/LukeTang1/Head-First-Design-Patterns/clap.wav"
for the file path, so that file clap.wav can be found.

Then for the interaction between interfaces and classes, we connect the classes to
the interface that it implements, we also use a dotted line for this. A arrow that from
class to interface, which means class use the method in interface.

Then we noticed that bmp is equal to 90 if we click increase or decrease. Then we change
the on function in BeatModel. We deleted the int bpm = 90, and add notifyBPMObservers();
so java knows the update for bpm.

List of source code files:

BeatBar.java
BeatController.java
BeatModel.java
BeatModelInterface.java
BeatObserver.java
BPMObserver.java
ControllerInterface.java
DJTestDrive.java
DJView.java
DJViewHttpHandler.java
DJViewHttpServer.java
HeartAdapter.java
HeartController.java
HeartModel.java
HeartModelInterface.java
HeartTestDrive.java