@num_test = 155
@in_0 = []
@in_org_0 = []
@in_1 = []
@in_org_1 = []
@out = []


def load_test
    f = File.new("judge/tests/isomorphic-strings.txt")
    @in_0 = read_string_array(f)
    @in_org_0 = @in_0.dup
    @in_1 = read_string_array(f)
    @in_org_1 = @in_1.dup
    @out = read_bool_array(f)
    f.close
end

def judge
    load_test

    start_time = Time.now

    (0...@num_test).each do |i|
        answer = is_isomorphic(@in_0[i], @in_1[i]) 
        if answer != @out[i]
            print "#{i+1} / #{@num_test};"
            print @in_org_0[i]
            print ', '
            print @in_org_1[i]
            print ';'
            print answer
            print ';'
            print @out[i]
            puts
            return
        end
    end

    runtime = (Time.now - start_time) * 1000.0
    puts('Accepted;' + runtime.to_i.to_s)
end
