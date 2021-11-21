# README

本游戏主要通过`Swing`和`awt`来实现一个“葫芦娃大战妖精”的2D横版射击游戏，借鉴游戏有：崩坏学园2、飞机大战等



## 代码结构

代码结构如下：

```
.
│  pom.xml	# Maven Config File
│  README.md	# This File
│
├─.idea
│
└─src
   ├─main
   │  └─java
   │      ├─com.nju.edu
   |	  		 |
   │             ├─bullet
   | 			 |    CalabashBullet.java   # 葫芦娃子弹类
   |			 |    MonsterBullet.java    # 妖精子弹类
   |			 |     
   |             ├─control
   |             |    GameController.java   # 游戏的控制类，进行线程的管理和Panel的绘制等
   |             |    
   |             ├─game
   |             |    Game.java             # 游戏的入口与主类，主要是初始化GameScreen
   |			 |
   |   			 ├─screen
   |             |	  GameScreen.java       # 继承了JFrame，游戏的主屏幕
   |			 |	  RenderThread.java     # 用于强行刷新屏幕的类，单独的线程管理
   |			 |
   |			 ├─sprite
   |			 |	  Calabash.java 		# 葫芦娃类，继承自Sprite
   |			 |	  GameObject.java   	# 游戏物体类，所有游戏内的物体都继承了该类
   |			 |	  Monster.java			# 妖精接口，声明了妖精的发射子弹方法
   |			 |	  MonsterOne.java		# 第一类妖精，继承自Sprite
   |			 |	  MonsterTwo.java	 	# 第二类妖精，继承自Sprite
   |			 |	  MonsterThree.java		# 第三类妖精，继承自Sprite
   |			 |	  Sprite.java			# 精灵类，继承自GameObject
   |			 |
   |			 ├─util
   |			 |	  GameState.java		# 游戏的一些状态，枚举类
   |			 |	  ReadImage.java		# 读取游戏图片的一个工具类
   |
   |
   └─test
       └─java
           └─com.nju.edu
              	  └─sprite
```



### 关于GameController

`GameController.java`是本游戏实现过程中最复杂的类了，其中集成了两个内部类`CalabashThread.java`和`MonsterThread.java`，这两个内部类都实现了`Runnable`接口，本意其实是想要将这两个类单独出来的，但由于这两个类需要用到`GameController`中的许多数据，所以就当做内部类了。

同时，`GameController`自己也实现了`Runnable`接口，主要是做一些子弹碰撞的检测和防止两个妖精走到同一格的管理。



## 代码实现

类似于一个“飞机大战”的游戏，葫芦娃的目标就是击败妖精保护爷爷（爷爷类暂时还未添加，后面会加上）。敌方分为三种妖精：

### 妖精一

移动速度较快，但是只会单向移动，发射子弹的速度也比较快

### 妖精二

移动速度较慢，但是会上下移动，发射子弹速度较慢

### 妖精三

会变换速度，并自动前往爷爷所在的地方（还未实现）。



