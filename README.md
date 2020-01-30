# ecommerce-shopping-backend

Project Package
com.tcrb.shoppingcart.(ระบุ domain).(ระบุ subpackage)

ชื่อ Domain ประกอบด้วย
  - product
  - customer
  - shipping
  - payment
  
  # Commit Message
  เริ่มต้นด้วย tag ต่อไปนี้ แล้วตามด้วยข้อความรายละเอียด ใช้ภาษาไทยเท่านั้น
  [Created] สร้างไฟล์ใหม่
  [Edited] แก้ไข หรือ เพิ่ม function code ในไฟล์เดิมที่มีอยู่แล้ว รวมถึงกรณี refactor code
  [Deleted] ลบไฟล์ออก
  
  
  # การทำงานกับ Resource
  - ชื่อต้องเป็นพหูพจน์ เช่น products
  - url ต้องขึ้นต้นด้วย /api/[version]/[result]
  - Attribute ไม่ต้องใส่ชื่อ resource
  
  # การกำหนด Method 
  - Get ใช้สำหรับดึงข้อมูล
  - Post ใช้บันทึกข้อมูล
  
  # รายละเอียดของ Method Get
  - ไม่ใส่ Parameter จะ Return List
  - ใส่ Parameter จะ Return Detail ของข้อมูล
  
  # Project package structure
  com.tcrb.shoppingcart.product  
  com.tcrb.shoppingcart.customer  
  com.tcrb.shoppingcart.payment  
  com.tcrb.shoppingcart.shipping  
  
