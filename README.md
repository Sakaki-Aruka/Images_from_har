# Images_from_har  

# Warning  
The creator of this program, Sakaki-Aruka, will not be held responsible for any damages incurred from the use of this program.
  
## Settings Files  
 - harPath.txt : A path of a target har file.

## Notice  
* This program cannot download images, when you run this on Windows.
  * When you use a Windows PC, I suggest to run this on WSL.
* When you forget to write "harPath.txt", this program cannot work.

# How to Use
1. Go Twitter's bookmark page. (https://twitter.com/i/bookmarks)
2. Open Google Chrome Developper tools.  
(When you use an other browser, open a tool that can check network traffic and output those to a har file.)
3. Scroll to the bottom of the page. (Slowly as the browser can load each images.)
4. Download a har file from a browser.
5. Place a downloaded har file to same directory with this program.
6. Check to exist "harTest.class" on the target directory, and run "java harTest" command.
