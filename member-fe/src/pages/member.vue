<template>
  <el-button type="primary" @click="memberLogout">登出</el-button>
</template>

<script>
    export default {
      name: "member",
      methods: {
        memberLogout() {
          this.$api.backLogout()
            .then(response => {
              if(response.data.success === true) {
                this.$alert(response.data.message, '登出', {
                  confirmButtonText: '确定',
                  callback: action => {}
                });
              } else {
                this.$message('未登录！');
                window.location = '/';
              }
            })
            .catch(error => {
              this.$message('发生错误了！');
          })
        }
      }
    }
</script>

<style scoped>

</style>
