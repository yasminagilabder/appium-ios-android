java -jar src/test/drivers/selenium-server-standalone-3.11.0.jar -role hub -host "127.0.0.1" &
appium --nodeconfig src/app/nodes-config/ios-node1.json -p 4730 -cp 4730 &
appium --nodeconfig src/app/nodes-config/ios-node2.json -p 4790 -cp 4790 &
ios-sim showdevicetypes
ios-sim start --devicetypeid "iPhone-11-Pro-Max, 13.5" &
ios-sim start --devicetypeid "iPhone-8, 13.5" &


