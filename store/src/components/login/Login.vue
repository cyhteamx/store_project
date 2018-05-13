<template>
    <div class="login-wrap">
        <div class="ms-title">后台管理系统</div>
        <div class="ms-login">
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="0px" class="demo-ruleForm">
                <el-form-item prop="username">
                    <el-input v-model="ruleForm.username" placeholder="username"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input type="password" placeholder="password" v-model="ruleForm.password" @keyup.enter.native="submitForm('ruleForm')"></el-input>
                </el-form-item>
                <div class="login-btn">
                    <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
                </div>
            </el-form>
        </div>
    </div>
</template>

<script>
  import axios from 'axios'

  var config = require('config')
  config = process.env.NODE_ENV === 'development' ? config.dev : config.build
  const ERR_OK = 200;

  export default {
        data: function() {
            return {
                ruleForm: {
                    username: '',
                    password: ''
                },
                rules: {
                    username: [
                        { required: true, message: '请输入用户名', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' }
                    ]
                }
            }
        },
        methods: {
            submitForm(formName) {
              const self = this;

              axios.post('/auth/jwt/token', {
                loginname: 'admin',
                password: 'admin'
              }).then(response => {
                response = response.data;
                if (response.code === ERR_OK) {
                  if (response.data === null) {
                    alert('error.');
                  } else {
                    localStorage.setItem('access-token', response.data);
                    axios.get('/admin/login', {
                        params: {
                          name: self.ruleForm.username,
                          pass: self.ruleForm.password
                        }
                      }).then(response => {
                      response = response.data;
                      if (response.code === ERR_OK) {
                        if (response.data === null) {
                          alert('error.');
                        } else {
                          self.$router.push('/');
                        }
                      } else {
                        alert('error submit!!');
                        return false;
                      }
                    });
                  }
                } else {
                  alert('error submit!!');
                  return false;
                }
                // if (res.data.success) {
                //   //保存soket.io
                //   localStorage.setItem('access-token', res.data);
                //   //弹窗
                //   this.messageBox.messageBoxEvent = 'login'
                //   this.messageBox.visible = true;
                //   this.messageBox.message = "您已登录成功"
                // } else {
                //   this.$message({
                //     message: res.data.message,
                //     type: "error"
                //   });
                // }
              }).catch(err => {
                console.log(err)
                this.$message({
                  message: '服务器出错啦',
                  type: "error"
                });
              });


            }
        }
    }
</script>

<style scoped>
    .login-wrap{
        position: relative;
        width:100%;
        height:100%;
    }
    .ms-title{
        position: absolute;
        top:50%;
        width:100%;
        margin-top: -230px;
        text-align: center;
        font-size:30px;
        color: #fff;

    }
    .ms-login{
        position: absolute;
        left:50%;
        top:50%;
        width:300px;
        height:160px;
        margin:-150px 0 0 -190px;
        padding:40px;
        border-radius: 5px;
        background: #fff;
    }
    .login-btn{
        text-align: center;
    }
    .login-btn button{
        width:100%;
        height:36px;
    }
</style>
