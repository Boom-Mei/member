<template>
<!--  <el-container class="login">-->
    <el-row class="login">
      <el-col :offset="9" class="login-form">
        <el-form :model="member" :rules="rules" ref="member" label-width="100px" class="margin-top20">
          <el-form-item label="账号" prop="account">
            <el-input v-model="member.account" width="20px"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input v-model="member.password" width="20px" type="password"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="memberLogin">登陆</el-button>
            <el-button @click="resetForm('member')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
<!--  </el-container>-->
</template>

<script>
    export default {
      name: "login",
      data() {
          return {
            member: {
              account: '',
              password: ''
            },
            rules: {
              account: [
                { required: true, message: '请输入账号', trigger: 'blur' },
                { max: 10, message: '长度在 10 个字符内', trigger: 'blur' }
              ],
              password: [
                { required: true, message: '请输入密码', trigger: 'blur' },
                { min: 3, max: 16, message: '长度在 3 到 16 个字符', trigger: 'blur' }
              ]
            }
          }
      },
      methods: {
        memberLogin() {
          this.$api.backLogin(this.member)
            .then(response => {
            if (response.data.success === true) {
              this.$notify({
                title: '通知',
                message: '登陆成功！',
                type: 'success'
              });
              this.$router.push({
                path: '/index'
              })
            } else {
              this.$message(response.data.message);
            }
          })
            .catch(error => {
            this.$message('发生错误了！');
          })
        },
        resetForm(formName) {
          this.$refs[formName].resetFields();
        }
      }
    }
</script>

<style scoped>

</style>
