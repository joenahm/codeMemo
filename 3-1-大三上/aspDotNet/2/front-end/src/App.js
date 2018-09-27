import React, { Component } from 'react';
import { Card, Form, Icon, Input, Button } from 'antd';

const FormItem = Form.Item;

class Login extends Component {
  render() {
    const { form } = this.props;

    return (
      <Form onSubmit={this.handleSubmit} className="login-form">
        <FormItem>
          {form.getFieldDecorator('userName', {
            rules: [{ required: true, message: '用户名不能为空！' }],
          })(
            <Input prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />} placeholder="Username" />
          )}
        </FormItem>
        <FormItem>
          {form.getFieldDecorator('password', {
            rules: [{ required: true, message: '密码不能为空！' }],
          })(
            <Input prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />} type="password" placeholder="Password" />
          )}
        </FormItem>
        <FormItem>
          <Button type="primary" htmlType="submit" className="login-form-button">
            登录
          </Button>
        </FormItem>
      </Form>
    );
  }
}

const App = Form.create()(Login);
export default App;
